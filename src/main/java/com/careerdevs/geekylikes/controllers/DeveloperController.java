package com.careerdevs.geekylikes.controllers;

import com.careerdevs.geekylikes.models.Developer;
import com.careerdevs.geekylikes.repositories.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/developers")
public class DeveloperController {
    @Autowired
    private DeveloperRepository repository;


    @GetMapping
    public @ResponseBody List<Developer> getDevelopers() {
       return repository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Developer getOnrById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public @ResponseBody Developer createDeveloper(@RequestBody Developer newDeveloper) {
        return repository.save(newDeveloper);
    }


    @PutMapping("/{id}")
    public @ResponseBody Developer updateEmployee(@PathVariable Long id, @RequestBody Developer updates) {
        Developer developer = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (updates.getName() != null) developer.setName(updates.getName());
        if (updates.getEmail() != null) developer.setEmail(updates.getEmail());
        if (updates.getCohort() != null) developer.setCohort(updates.getCohort());
        if (updates.getLanguages() != null) developer.setLanguages(updates.getLanguages());

        return repository.save(developer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> destroyDev(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }



}
