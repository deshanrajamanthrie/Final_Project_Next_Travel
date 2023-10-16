package lk.ijse.gdse.vehicle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class VehicleManageInitializer {
    public static void main(String[] args) {
        SpringApplication.run(VehicleManageInitializer.class);

    }



}
