package com.example.webstoretask2.controller;

import com.example.webstoretask2.domain.Rack;
import com.example.webstoretask2.service.RackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rack")
public class RackController {
    private final RackService rackService;
    @PostMapping("/save")
    public ResponseEntity<Rack> saveRack(@RequestBody Rack rack) {
        return ResponseEntity.ok(rackService.saveRack(rack));

    }

    @GetMapping("/id")
    public ResponseEntity<Rack> getRackById(@RequestParam(name = "id") Integer id) {
        return ResponseEntity.ok(rackService.getById(id));

    }
    @GetMapping("/all")
    public ResponseEntity<List<Rack>> getAllRacks() {
        return ResponseEntity.ok(rackService.getAllRacks());

    }
    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteRack(@RequestParam(name = "id") Integer id) {
        return ResponseEntity.ok(rackService.deleteRack(id));

    }
    @PutMapping("/update")
    public ResponseEntity<Rack> updateRack(@RequestBody Rack rack) {
        return ResponseEntity.ok(rackService.updateRack(rack));

    }
}
