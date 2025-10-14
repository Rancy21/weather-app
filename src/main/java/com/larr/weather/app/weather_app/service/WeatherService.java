package com.larr.weather.app.weather_app.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.larr.weather.app.weather_app.model.WeatherResponse;

import reactor.core.publisher.Mono;

@Service
public class WeatherService {
    private final WebClient webClient;

    @Value("${weather.api.key}")
    private String key;

    @Value("${weather.api.base.url}")
    private String baseUrl;

    @Value("${weather.api.units}")
    private String unit;

    public WeatherService(WebClient.Builder webBuilder) {
        this.webClient = webBuilder.baseUrl(baseUrl).build();
    }

    @Cacheable(value = "weather-today", key = "#city")
    public Mono<WeatherResponse> getCurrentWeather(String city) {
        return webClient.get().uri(uriBuilder -> uriBuilder.path("/${city}/today").queryParam("unitGroup", unit)
                .queryParam("key", key).build()).retrieve().bodyToMono(WeatherResponse.class);
    }

}
