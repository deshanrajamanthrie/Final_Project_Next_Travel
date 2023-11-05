package lk.ijse.gdse.apigateway.dto;
import lombok.*;
import java.util.Collection;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TravelDTO {
    private long id;
    private String travelArea;
    private Collection<TravelDateDTO> dates;
    private int countDays;
    private String guide;
    private int noChildren;
    private int noAdult;
    private int headCount;
    private double paidValue;
    private PackageCategoryDTO packageCategory;
}
