package com.newsaggregator.news_aggregator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages = "com.newsaggregator")
public class NewsAggregatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsAggregatorApplication.class, args);
	}
  // rest template -> without it we can't call HTTP
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
