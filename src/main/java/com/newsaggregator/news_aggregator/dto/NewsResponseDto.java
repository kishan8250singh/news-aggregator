package com.newsaggregator.news_aggregator.dto;

import lombok.Data;

import java.util.List;

@Data
public class NewsResponseDto {
    // status of NewsApi response
    private String status;
    // number of article
    private int totalResults;
    // Actual article ki list
    private List<ArticleDto> articles;
}
