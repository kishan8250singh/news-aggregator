package com.newsaggregator.news_aggregator.service;

import com.newsaggregator.news_aggregator.Entity.Topic;
import com.newsaggregator.news_aggregator.Entity.User;
import com.newsaggregator.news_aggregator.Repository.Topic_repo;
import com.newsaggregator.news_aggregator.Repository.User_repo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TopicService {
    private static final Logger log = LoggerFactory.getLogger(TopicService.class);

    @Autowired
    private Topic_repo topic_repo;

    @Autowired
    private User_repo user_repo;

    // set the  user topic if not already exist in DB by using Set data structure
    public User saveUserTopics(User user, List<String> topicNames) {

        //log.info("Saving topics for user: {}", user.getEmail());
        Set<Topic> topics = topicNames.stream()
                .map(name -> {
                    // check if already topic exist ?
                    return topic_repo.findByName(name.toLowerCase())
                            .orElseGet(() -> {
                                Topic t = new Topic();
                                t.setName(name.toLowerCase());
                                return topic_repo.save(t);
                            });
                })
                .collect(Collectors.toSet());
        // link user with  its topic
        user.setTopics(topics);
        return user_repo.save(user);
    }
        // fetch user topic
        public Set<Topic> getUserTopics(User user){
            log.info("fetching topics for user: {}", user.getEmail());
            return user.getTopics();
        }
    }

