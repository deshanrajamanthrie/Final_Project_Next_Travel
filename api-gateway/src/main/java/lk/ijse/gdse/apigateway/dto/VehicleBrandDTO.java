package lk.ijse.gdse.apigateway.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class VehicleBrandDTO {
    private long vehicleId;
    private String brandName;
    private int seat;
    private int qty;
    private String fuelType;
    private double fee1km;
    private double fuel1km;
    private double feeForOneDay;
    private byte[] images;
    private VehicleCategoryDTO category;
}
