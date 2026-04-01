package com.newsaggregator.news_aggregator.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name  = "topics")
@Data
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String name; // like sport,technology,world
}
