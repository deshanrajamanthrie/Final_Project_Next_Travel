package lk.ijse.gdse.vehicle.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @Column(nullable = false,length = 45)
    private double fee1km;

    @Column(nullable = false,length = 45)
    private double fuel1km;

    @ManyToOne
    @JoinColumn(name = "category_Id")
    private VehicleCategory category;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "vehicleBrand",fetch = FetchType.LAZY)
    private List<VehicleImage>images;

    public VehicleBrand(long vehicleId, String brandName, int seat, String fuelType, double fee1km, double fuel1km) {
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
    }
}
