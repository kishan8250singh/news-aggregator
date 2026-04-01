package com.newsaggregator.news_aggregator.Repository;

import com.newsaggregator.news_aggregator.Entity.SavedArticle;
import com.newsaggregator.news_aggregator.Entity.User;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavedArticle_repo extends JpaRepository<SavedArticle,Long> {
    List<SavedArticle> findByUser(User user);
    void deleteByIdAndUser(Long id,User user);
}
