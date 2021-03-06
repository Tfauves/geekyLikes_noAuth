package com.careerdevs.geekylikes.repositories;

import com.careerdevs.geekylikes.models.developer.Developer;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface DeveloperRepository extends JpaRepository<Developer, Long> {

     List<Developer> findAllByCohort(Integer cohort, Sort sort);
     List<Developer> findAllByLanguages_id(Long id);
     List<Developer> findAllByApprovals_geekout_id(Long id);
}
