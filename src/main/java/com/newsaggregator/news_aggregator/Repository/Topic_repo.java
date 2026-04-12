package com.newsaggregator.news_aggregator.Repository;

import com.newsaggregator.news_aggregator.Entity.Topic;
import net.minidev.asm.ConvertDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Topic_repo extends JpaRepository<Topic,Long> {
    Optional<Topic> findByName(String lowerCase);
  //   boolean exitsByName(String name);
}
