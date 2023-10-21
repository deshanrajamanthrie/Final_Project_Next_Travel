package lk.ijse.gdse.hotelService;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HotelManageInitializer {
    public static void main(String[] args) {
        SpringApplication.run(HotelManageInitializer.class);
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
