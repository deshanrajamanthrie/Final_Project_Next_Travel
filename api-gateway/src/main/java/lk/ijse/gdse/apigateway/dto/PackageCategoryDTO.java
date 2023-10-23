package lk.ijse.gdse.apigateway.dto;

import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PackageCategoryDTO {
    private String id;
    private String category;
    private List<TravelDTO> travels;
}
