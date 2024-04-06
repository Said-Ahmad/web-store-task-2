package com.example.webstoretask2.service;

import com.example.webstoretask2.domain.Order;
import com.example.webstoretask2.domain.Product;
import com.example.webstoretask2.domain.Rack;
import com.example.webstoretask2.entity.OrderAndProductsEntity;
import com.example.webstoretask2.entity.OrderEntity;
import com.example.webstoretask2.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;
    private final RackRepository rackRepository;
    private final ProductAndRacksRepository productAndRacksRepository;
    private final OrderAndProductRepository orderAndProductRepository;

    public Order saveOrder(Order order) {
        OrderEntity orderEntity = orderRepository.save(modelMapper.map(order, OrderEntity.class));
        return modelMapper.map(orderEntity, Order.class);
    }

    public Order getById(Integer id) {
        Order order = orderRepository.findByNumberOfOrder(id)
                .map(e -> modelMapper.map(e, Order.class)).orElseThrow();

        var productIds = orderAndProductRepository
                .findAllByOrderId(order.getId()).stream()
                .map(OrderAndProductsEntity::getProductId).collect(Collectors.toList());

        var productList = productRepository.findAllByIdIn(productIds).stream()
                .map(productEntity -> modelMapper.map(productEntity, Product.class)).collect(Collectors.toList());
        productList.forEach(e -> {
            e.setCount((int) productIds.stream().filter(i -> Objects.equals(i, e.getId())).count());
            List<Rack> racks = new ArrayList<>();
            productAndRacksRepository.findAllByProductId(e.getId())
                    .forEach(ra -> {
                        if (ra.getIsPrimary()) {
                            e.setRacks(rackRepository.findById(ra.getRackId())
                                    .map(r -> modelMapper.map(r, Rack.class)).orElse(null));
                        } else {
                            racks.add(rackRepository.findById(ra.getRackId())
                                    .map(r -> modelMapper.map(r, Rack.class)).orElse(null));
                        }
                    });
            e.setAdditionalRacks(racks);
        });

        order.setProducts(productList);
        return order;

    }


    public List<Order> getAllOrders() {
        List<Order> orders = orderRepository.findAllByNumberOfOrderIn(List.of(10, 11, 14, 15))
                .stream().map(e -> modelMapper.map(e, Order.class)).collect(Collectors.toList());


        orders.forEach(order -> {
            var productIds = orderAndProductRepository
                    .findAllByOrderId(order.getId()).stream()
                    .map(OrderAndProductsEntity::getProductId).collect(Collectors.toList());

            var productList = productRepository.findAllByIdIn(productIds).stream()
                    .map(productEntity -> modelMapper.map(productEntity, Product.class)).collect(Collectors.toList());
            productList.forEach(e -> {
                e.setCount((int) productIds.stream().filter(i -> Objects.equals(i, e.getId())).count());
                List<Rack> racks = new ArrayList<>();
                productAndRacksRepository.findAllByProductId(e.getId())
                        .forEach(ra -> {
                            if (ra.getIsPrimary()) {
                                e.setRacks(rackRepository.findById(ra.getRackId())
                                        .map(r -> modelMapper.map(r, Rack.class)).orElse(null));
                            } else {
                                racks.add(rackRepository.findById(ra.getRackId())
                                        .map(r -> modelMapper.map(r, Rack.class)).orElse(null));
                            }
                        });
                e.setAdditionalRacks(racks);
            });

            order.setProducts(productList);
        });
        System.out.print("Page of orders:");
        orders.forEach(order -> {
            System.out.print(order.getNumberOfOrder()+" ");
        });
        System.out.println();
        orders.forEach(order -> {
            order.getProducts().forEach(product -> {
                System.out.println("==== Rack " + product.getRacks().getName());
                System.out.println(product.getName() + " id = (" + product.getId() + ") ");
                System.out.println("order:" + order.getNumberOfOrder() + "," + product.getCount() + "(units)");
                product.getAdditionalRacks().forEach(rack -> {
                    System.out.println("additional rack:" + rack.getName());
                });
                System.out.println("-------------------------");
            });

        });
        return orders;
    }

    public Order updateOrder(Order order) {
        boolean result = orderRepository.existsById(order.getId());
        if (!result) {
            log.warn("Error :{}", order.getId());
            throw new RuntimeException("ERROR");
        }

        return this.saveOrder(order);

    }

    public Boolean deleteOrder(Integer id) {
        orderRepository.deleteById(id);
        Optional<OrderEntity> optional = orderRepository.findById(id);
        return !optional.isPresent();
    }
}
