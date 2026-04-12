package com.newsaggregator.news_aggregator.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {
    @GetMapping("/dashboard")
    public Map<String, String> dashboard(
            @AuthenticationPrincipal OAuth2User principal)

    {
        String email = null;
        String name = null;
        if (principal != null) {
            email = principal.getAttribute("email");
            name = principal.getAttribute("name");
        } else {
            email = "Unknown";
            name = "Unknown";
        }
        assert name != null;
        assert email != null;
        return Map.of(
                "message", "Login Successful",
                "name", name,
                "email", email
        );
    }
}
