package org.obrii.dp2021.restConsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.config.HypermediaRestTemplateConfigurer;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestConsumerApplication.class, args);
    }

    @Bean
    RestTemplateCustomizer hypermediaRestTemplateCustomizer(HypermediaRestTemplateConfigurer configurer) {
        return restTemplate -> {
            configurer.registerHypermediaTypes(restTemplate);
        };
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
    return builder.build();
    }
}
