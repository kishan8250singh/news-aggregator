package com.newsaggregator.news_aggregator.service;

import com.newsaggregator.news_aggregator.Entity.User;
import com.newsaggregator.news_aggregator.Repository.User_repo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private User_repo userRepo;

   // create or fetch user  by Oauth2
    public User getOrCreateUser(OAuth2User oAuth2User){
        String email = oAuth2User.getAttribute("email");
        log.info("Fetching user with email: {}", email);
        String name  = oAuth2User.getAttribute("name");
        log.info("Fetching user with name: {}", name);
        // check user exists or not in db
        return userRepo.findByEmail(email)
                .orElseGet(()->{
                    log.info("New user created : {}",email);
                    User newuser = new User();
                    newuser.setName(name);
                    newuser.setEmail(email);
                    return userRepo.save(newuser);
                });
    }
}
