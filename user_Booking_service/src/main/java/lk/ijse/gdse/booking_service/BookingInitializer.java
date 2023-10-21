package lk.ijse.gdse.booking_service;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookingInitializer {
    public static void main(String[] args) {
        SpringApplication.run(BookingInitializer.class);
    }
    @Bean
    public ModelMapper mapper(){
       return new ModelMapper();
    }
}
