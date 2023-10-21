package lk.ijse.gdse.vehicle.dto;

import jakarta.persistence.*;
import lk.ijse.gdse.vehicle.entity.VehicleCategory;
import lk.ijse.gdse.vehicle.entity.VehicleImage;
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


    private VehicleCategory category;


    private List<VehicleImage> images;

  /*  public VehicleBrand(long vehicleId, String brandName, int seat, String fuelType, double fee1km, double fuel1km) {
        this.vehicleId = vehicleId;
        this.brandName = brandName;
        this.seat = seat;
        this.fuelType = fuelType;
        this.fee1km = fee1km;
        this.fuel1km = fuel1km;
    }

    public VehicleBrand(long vehicleId, String brandName, int seat, String fuelType, double fee1km, double fuel1km, VehicleCategory category) {
        this.vehicleId = vehicleId;
        this.brandName = brandName;
        this.seat = seat;
        this.fuelType = fuelType;
        this.fee1km = fee1km;
        this.fuel1km = fuel1km;
        this.category = category;
    }*/


}
