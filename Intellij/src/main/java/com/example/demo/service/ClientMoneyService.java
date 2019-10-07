package com.example.demo.service;

import com.example.demo.domain.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class ClientMoneyService {

    @Autowired
    private RestTemplateBuilder builder;

    @Bean
    public RestTemplate restTemplate() {
        return builder.rootUri("http://localhost:8080").build();
    }

    public Money useBuilder() {
        Money p = restTemplate().getForObject("/hello/moneys", Money.class);
        return p;
    }

}
