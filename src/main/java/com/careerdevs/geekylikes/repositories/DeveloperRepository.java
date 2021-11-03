package com.careerdevs.geekylikes.repositories;

import com.careerdevs.geekylikes.models.Developer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DeveloperRepository extends JpaRepository<Developer, Long> {
}
