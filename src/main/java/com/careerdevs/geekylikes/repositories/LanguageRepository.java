package com.careerdevs.geekylikes.repositories;

import com.careerdevs.geekylikes.models.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long> {
}
