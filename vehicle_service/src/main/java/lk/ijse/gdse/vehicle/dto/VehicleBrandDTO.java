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

    private int qty;

    private String fuelType;


    private double fee1km;


    private double fuel1km;

    private byte[] images;

    private VehicleCategory category;

    public VehicleBrandDTO(long vehicleId, String brandName, int seat, int qty, String fuelType, double fee1km, double fuel1km, VehicleCategory category) {
        this.vehicleId = vehicleId;
        this.brandName = brandName;
        this.seat = seat;
        this.qty = qty;
        this.fuelType = fuelType;
        this.fee1km = fee1km;
        this.fuel1km = fuel1km;

        this.category = category;
    }
}
