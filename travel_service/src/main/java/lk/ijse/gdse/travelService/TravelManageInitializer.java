package lk.ijse.gdse.travelService;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TravelManageInitializer {
    public static void main(String[] args) {
        SpringApplication.run(TravelManageInitializer.class);
    }
    @Bean
    public ModelMapper modelMapper(){
       return new ModelMapper();
    }
}
