package lk.ijse.gdse.vehicle.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class VehicleCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(nullable = false, length = 45)
    private long categoryId;

    @Column(nullable = false, length = 45)
    private String categoryType;


    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @ToString.Exclude
    @JsonIgnore
    private List<VehicleBrand> vehicleBrands;

    public VehicleCategory(long categoryId, String categoryType) {
        this.categoryId = categoryId;
        this.categoryType = categoryType;
    }
}
