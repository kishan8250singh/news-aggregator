package com.newsaggregator.news_aggregator.controller;
import com.newsaggregator.news_aggregator.dto.ArticleDto;
import com.newsaggregator.news_aggregator.service.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api/news")
public class NewsController {
    private static final Logger log = LoggerFactory.getLogger(NewsController.class);
    @Autowired
    private NewsService newsService;
    @GetMapping // handle get request to /api/news
    // RequestParam -> URL me topic ke sath aayega, agar topic nahi diya gaya to default value "technology" use hoga
    public List<ArticleDto> getNews(@RequestParam(defaultValue = "technology") String topic){
        log.info("Received request to fetch news for topic: {}", topic);
        return newsService.getNewsByTopic(topic);
    }
}
