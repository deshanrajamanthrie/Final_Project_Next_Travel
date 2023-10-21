package lk.ijse.gdse.guide;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GuideServiceInitializer {
    public static void main(String[] args) {
        SpringApplication.run(GuideServiceInitializer.class);
    }

    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }
}
