package com.newsaggregator.news_aggregator.service;

import com.newsaggregator.news_aggregator.dto.ArticleDto;
import com.newsaggregator.news_aggregator.dto.NewsResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class NewsService {
    private static final Logger log = LoggerFactory.getLogger(NewsService.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value("${news.api.key}") // take the value from app.properties
    private String apikey;

    private static final String NEWS_API_URL =
            "https://newsapi.org/v2/everything" +
                    "?q={topic}" +
                    "&sortBy=publishedAt" +
                    "&pageSize=10" +
                    "&apiKey={apiKey}";

    // this method fetch news by taking topic
    public List<ArticleDto> getNewsByTopic(String topic){
        log.info("Fetching news for topic:{}",topic);
        try{
            // Rest template se Get req. send kro and response automatically NewsResponseDto me convert ho jayega
            NewsResponseDto response = restTemplate.getForObject(NEWS_API_URL,NewsResponseDto.class,topic,apikey);
            if(response!=null && "ok".equals(response.getStatus())){
                log.info("Fetched article for topic : {}",
                       topic);
                return response.getArticles();
            }
            // if no response
            log.info("No news found for topic: {}",topic);
            return Collections.emptyList();
        } catch (Exception e) {
            log.error("Failed to fetch news for topic: {}", topic, e);
            return Collections.emptyList();
        }
    }
}
