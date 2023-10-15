package lk.ijse.gdse.vehicle.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lk.ijse.gdse.vehicle.entity.VehicleBrand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleCategoryDTO {
    private long categoryId;


    private String categoryType;


    private List<VehicleBrand> vehicleBrands;

    public VehicleCategoryDTO(long categoryId, String categoryType) {
        this.categoryId = categoryId;
        this.categoryType = categoryType;
    }
}
