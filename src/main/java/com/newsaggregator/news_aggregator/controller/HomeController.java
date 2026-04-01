package com.newsaggregator.news_aggregator.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RestController
public class HomeController {
    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/")
    public String home() {
        return "App is running! Go to / login to start!";
    }

    @GetMapping("/dashboard")
    public Map<String, Object> dashboard(
            @AuthenticationPrincipal OAuth2User principal) {

        String email = principal.getAttribute("email");
        String name = principal.getAttribute("name");

        log.info("User logged in: {}", email);


        return Map.of(
                "message", "Login Successful! 🎉",
                "name", name,
                "email", email
        );
    }
}
