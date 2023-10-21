package lk.ijse.gdse.user;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserManageInitializer {
    public static void main(String[] args) {
        SpringApplication.run(UserManageInitializer.class);
    }

    @Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }


}
