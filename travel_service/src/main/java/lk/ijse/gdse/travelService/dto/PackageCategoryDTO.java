package lk.ijse.gdse.travelService.dto;

import lk.ijse.gdse.travelService.entity.Travel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PackageCategoryDTO {
    private String id;
    private String category;
    private List<TravelDTO> travels;
}
