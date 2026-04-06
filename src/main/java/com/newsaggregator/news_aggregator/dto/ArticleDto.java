package com.newsaggregator.news_aggregator.dto;

import lombok.Data;

@Data
public class ArticleDto {
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;
    private String sourceName;


}
