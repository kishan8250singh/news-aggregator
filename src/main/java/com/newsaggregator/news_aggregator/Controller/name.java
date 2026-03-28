package com.newsaggregator.news_aggregator.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class name {
    @GetMapping("/name")
    public String getName() {
        return "kishan";
    }
}
