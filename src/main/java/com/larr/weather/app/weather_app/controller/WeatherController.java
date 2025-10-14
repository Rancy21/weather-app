package com.larr.weather.app.weather_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.larr.weather.app.weather_app.service.WeatherService;

@RestController
@RequestMapping(value = "/api")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping(value = "/weather-today/{city}")
    public ResponseEntity<?> getCurrentWeather(@PathVariable String city) {
        try {
            return ResponseEntity.ok().body(weatherService.getCurrentWeather(city));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

}
