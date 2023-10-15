package lk.ijse.gdse.vehicle.dto;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lk.ijse.gdse.vehicle.entity.VehicleCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleBrandDTO {
    private long vehicleId;

    private String brandName;

    private int seat;

    private String fuelType;

    private byte[] image;

    private double fee1km;

    private double fuel1km;

    private VehicleCategory category;


}
