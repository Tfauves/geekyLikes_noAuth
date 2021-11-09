package com.careerdevs.geekylikes.models;


import javax.persistence.*;

@Entity
public class Geekout {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "developer_id")
    private Developer developer;



    private String title;
    private String content;
}
