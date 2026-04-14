# 📰 AI News Aggregator

A personalized news aggregator built with Spring Boot, 
Spring AI, and Google OAuth2.

##  Features
- Google OAuth2 Login
- Personalized topic preferences
- Live news from NewsAPI
- AI-powered summaries 
- Daily email digest

##  Tech Stack
- Java 21
- Spring Boot 3.5
- Spring Security + OAuth2
- Spring AI + Google Gemini
- MySQL + JPA
- NewsAPI
- Logback

### Prerequisites
- Java 21
- MySQL 8
- Maven

### Use Environment Variables of Local System to hide secrets
- GOOGLE_CLIENT_ID=your_client_id
- GOOGLE_CLIENT_SECRET=your_client_secret
- DB_PASSWORD=your_mysql_password
- NEWS_API_KEY=your_newsapi_key

### Run Application : 
```bash
mvn spring-boot:run
```

##  Test API Endpoints

| Method | URL | Description |
|--------|-----|-------------|
| GET |  /dashboard | User info after login |
| GET |  /api/news?topic=technology | Fetch news by topic |
| POST |  /api/topics | Save user topics |
| GET |  /api/topics | Get user topics |
