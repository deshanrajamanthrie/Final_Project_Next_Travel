package lk.ijse.gdse.vehicle.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "vehicleBrand")
public class VehicleBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,length = 45)
    private long vehicleId;
    @Column(nullable = false,length = 45)
    private String brandName;
    @Column(nullable = false,length = 45)
    private int seat;

    private String fuelType;
    @Lob
    private byte[] image;
    @Column(nullable = false,length = 45)
    private double fee1km;
    @Column(nullable = false,length = 45)
    private double fuel1km;

    @ManyToOne
    @JoinColumn(name = "category_Id")
    private VehicleCategory category;


}
