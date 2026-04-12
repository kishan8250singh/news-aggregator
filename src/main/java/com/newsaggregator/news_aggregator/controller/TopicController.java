package com.newsaggregator.news_aggregator.controller;

import com.newsaggregator.news_aggregator.Entity.Topic;
import com.newsaggregator.news_aggregator.Entity.User;
import com.newsaggregator.news_aggregator.service.TopicService;
import com.newsaggregator.news_aggregator.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/topics")
public class TopicController {
    private static final Logger log = LoggerFactory.getLogger(TopicController.class);
    @Autowired
    private TopicService topicService;
    @Autowired
    private UserService userService;
    // POST -> api/topics -> save user topic
    @PostMapping
    public User saveTopic(
            @AuthenticationPrincipal OAuth2User principal,
            @RequestBody List<String> topicNames){
        log.info("saving topic request received");
        // logged in user ka object lao
        User user = userService.getOrCreateUser(principal);
        // topic save
        return topicService.saveUserTopics(user,topicNames);
    }
    // GET -> api/topics -> fetch user topic
    @GetMapping
    public Set<Topic> getTopic(
            @AuthenticationPrincipal OAuth2User principal){
        log.info("get topic request received");
        // logged in user ka object lao
        User user = userService.getOrCreateUser(principal);
        // topic fetch
        return topicService.getUserTopics(user);
}
}
