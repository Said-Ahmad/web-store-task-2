package com.example.webstoretask2.service;

import com.example.webstoretask2.domain.Rack;
import com.example.webstoretask2.entity.RackEntity;
import com.example.webstoretask2.repository.RackRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class RackService {
    private final RackRepository rackRepository;
    private final ModelMapper modelMapper;

    public Rack saveRack(Rack rack) {
        RackEntity rackEntity = rackRepository.save(modelMapper.map(rack, RackEntity.class));
        return modelMapper.map(rackEntity, Rack.class);
    }

    public Rack getById(Integer id) {
        Optional<RackEntity> optional = rackRepository.findById(id);
        return optional.map(item -> modelMapper.map(item, Rack.class)).orElse(null);
    }


    public List<Rack> getAllRacks() {
        List<RackEntity> list = rackRepository.findAll();
        return list.stream().map(item -> modelMapper.map(item, Rack.class)).collect(Collectors.toList());
    }

    public Rack updateRack(Rack rack) {
        boolean result = rackRepository.existsById(rack.getId());
        if (!result) {
            log.warn("Error :{}", rack.getId());
            throw new RuntimeException("ERROR");
        }

        return this.saveRack(rack);

    }

    public Boolean deleteRack(Integer id) {
        rackRepository.deleteById(id);
        Optional<RackEntity> optional = rackRepository.findById(id);
        return !optional.isPresent();
    }
}
