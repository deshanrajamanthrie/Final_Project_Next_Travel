package lk.ijse.gdse.vehicle.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lk.ijse.gdse.vehicle.entity.VehicleBrand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleImageDTO {
    private long imageId;

    @Lob
    private byte[] vehicleImage;

    private VehicleBrand vehicleBrand;
}
