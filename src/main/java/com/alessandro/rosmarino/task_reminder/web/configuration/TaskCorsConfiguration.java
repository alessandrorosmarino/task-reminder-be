package com.alessandro.rosmarino.task_reminder.web.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;


@Configuration
public class TaskCorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        String originAllowed = "localhost";
        try {
            URL ip = new URL("http://checkip.amazonaws.com");
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(ip.openStream())
            );
            originAllowed = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("ORIGIN: " + originAllowed);
        registry.addMapping("/**")
                .allowedMethods(CorsConfiguration.ALL)
                .allowedHeaders(CorsConfiguration.ALL)
                .allowedOriginPatterns("http://"+originAllowed);
    }
}
