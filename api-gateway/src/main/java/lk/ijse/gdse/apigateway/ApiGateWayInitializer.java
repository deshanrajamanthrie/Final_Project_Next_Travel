package lk.ijse.gdse.apigateway;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ApiGateWayInitializer {
    public static void main(String[] args) {
        SpringApplication.run(ApiGateWayInitializer.class);
    }

    @Bean
    public RestTemplate restTemplate(){
      return new RestTemplate();
    }

}
