package com.newsaggregator.news_aggregator.Repository;

import com.newsaggregator.news_aggregator.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface User_repo extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
}
