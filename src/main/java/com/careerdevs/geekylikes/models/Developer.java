package com.careerdevs.geekylikes.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Developer {
    @Id @GeneratedValue private Long id;
    private String name;
    private String email;
    private Integer cohort;
    private List<String> languages;

    public Developer () {}

    public Developer(String name, String email, Integer cohort, List<String> languages) {
        this.name = name;
        this.email = email;
        this.cohort = cohort;
        this.languages = languages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCohort() {
        return cohort;
    }

    public void setCohort(Integer cohort) {
        this.cohort = cohort;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public void addLanguage(String lang) {
        languages.add(lang);
    }
}
