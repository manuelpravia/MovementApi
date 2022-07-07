package com.nttdata.movement.infraestructure.data.rest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("http://localhost:8082")
    private String accountApiUrl;

    @Bean
    WebClient accountApiWebClient(){
        return  WebClient.create(accountApiUrl);
    }
}
