package com.careerdevs.geekylikes.controllers;


import com.careerdevs.geekylikes.models.approve.Approve;
import com.careerdevs.geekylikes.models.developer.Developer;
import com.careerdevs.geekylikes.models.geekout.Geekout;
import com.careerdevs.geekylikes.repositories.ApproveRepository;
import com.careerdevs.geekylikes.repositories.GeekoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/geekouts")
public class GeekoutController {

    @Autowired
    private GeekoutRepository repository;

    @Autowired
    private ApproveRepository approveRepository;

    @GetMapping
    public ResponseEntity<Iterable<Geekout>> getAll() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Geekout getById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/dev/{devId}")
    public ResponseEntity<List<Geekout>> getByDevId(@PathVariable Long devId) {
        return new ResponseEntity<>(repository.findByDeveloperId(devId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Geekout> createOne(@RequestBody Geekout geekout) {
        System.out.println(geekout.getDeveloper().getId());

        return new ResponseEntity<>(repository.save(geekout), HttpStatus.CREATED);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Geekout> updateOne(@RequestBody Geekout updateData) {
//
//    }

    @PostMapping("/like/{id}")
    public ResponseEntity<Geekout> likeById(@PathVariable Long id, @RequestBody Developer developer) {
        Optional<Geekout> geekout = repository.findById(id);

        if (geekout.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        Approve newApproval = new Approve(developer, geekout.get());
        approveRepository.save(newApproval);
        return new ResponseEntity<>(geekout.get(), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> destroyOne(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
