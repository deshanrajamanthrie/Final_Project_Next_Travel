package lk.ijse.gdse.apigateway.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class VehicleCategoryDTO {
    private long categoryId;
    private String categoryType;
    private List<VehicleBrandDTO> vehicleBrands;
}
