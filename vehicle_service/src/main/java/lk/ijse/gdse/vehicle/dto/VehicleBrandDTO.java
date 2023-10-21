package lk.ijse.gdse.vehicle.dto;

import lk.ijse.gdse.vehicle.entity.VehicleCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleBrandDTO {
    private long vehicleId;


    private String brandName;


    private int seat;

    private String fuelType;


    private double fee1km;


    private double fuel1km;

    private byte[] images;

    private VehicleCategory category;





}
