package lk.ijse.gdse.hotel;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class HotelServiceInitializer {
    public static void main(String[] args) {
        SpringApplication.run(HotelServiceInitializer.class);
    }
    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }
}
