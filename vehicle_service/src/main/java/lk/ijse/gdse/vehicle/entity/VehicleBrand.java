package lk.ijse.gdse.vehicle.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
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
    @Column(nullable = false)
    private int qty;

    private String fuelType;

    @Column(nullable = false,length = 45)
    private double fee1km;

    @Column(nullable = false,length = 45)
    private double fuel1km;

    @Lob
    @Column(name = "imageData",nullable = true,columnDefinition = "MEDIUMBLOB")
    private byte[] images;

    @ToString.Exclude
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_Id")
    private VehicleCategory category;



}
