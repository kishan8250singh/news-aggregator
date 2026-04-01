package com.newsaggregator.news_aggregator.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.TypeBinderType;

import java.time.LocalDateTime;

@Entity
@Table(name = "saved_article")
@Data
public class SavedArticle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String url;
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @Column(columnDefinition = "TEXT")
    private String aiSummary; // summary of ai will store here

    private LocalDateTime savedAt = LocalDateTime.now();
}
