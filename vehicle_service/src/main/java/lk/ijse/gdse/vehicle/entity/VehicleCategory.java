package lk.ijse.gdse.vehicle.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,length = 45)
    private long categoryId;

    @Column(nullable = false,length = 45)
    private String categoryType;

    @ToString.Exclude
    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<VehicleBrand>vehicleBrands;

    public VehicleCategory(long categoryId, String categoryType) {
        this.categoryId = categoryId;
        this.categoryType = categoryType;
    }
}
