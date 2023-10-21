package lk.ijse.gdse.travelService.dto;

import jakarta.persistence.*;
import lk.ijse.gdse.travelService.entity.PackageCategory;
import lk.ijse.gdse.travelService.entity.embeded.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Collection;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TravelDTO {
    private String id;
    private String travelArea;
    private Collection<DateDTO> dates;
    private int countDays;
    private String guide;
    private int noChildren;
    private int noAdult;
    private int headCount;
    private double paidValue;
    private PackageCategory packageCategory;

}
