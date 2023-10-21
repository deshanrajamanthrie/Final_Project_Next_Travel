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
public class VehicleImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long imageId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type;

    @Lob
    @Column(name = "imageData",columnDefinition ="MEDIUMBLOB" )  //EXPAND THE IMAGE SIZE
    private byte[] vehicleImage;

    @ManyToOne
    @JoinColumn(name = "vehicleId")
    private VehicleBrand vehicleBrand;
}
