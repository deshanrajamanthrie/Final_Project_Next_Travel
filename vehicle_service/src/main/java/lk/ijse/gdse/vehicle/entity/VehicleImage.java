package lk.ijse.gdse.vehicle.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VehicleImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long imageId;
    private String name;
    private String type;
    @Lob
    @Column(name = "imageData")
    private byte[] vehicleImage;

    @ManyToOne
    @JoinColumn(name = "vehicleId")
    private VehicleBrand vehicleBrand;
}
