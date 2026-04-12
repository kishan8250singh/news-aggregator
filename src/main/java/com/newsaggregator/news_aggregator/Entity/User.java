package com.newsaggregator.news_aggregator.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;
import java.util.HashSet;
import java.util.Set;
import java.util.random.RandomGenerator;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true,nullable = false)
    private String email;

    private  String profilePicture;

    // Many to Many relation -:  many user can fetch many topics
    // used in TopicService -> user ke sath uska topic link krne me
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name  = "user_topics",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "topic_id")
    )
    private Set<Topic> topics = new HashSet<>();

}
