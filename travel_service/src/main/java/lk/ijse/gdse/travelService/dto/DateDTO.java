package lk.ijse.gdse.travelService.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lk.ijse.gdse.travelService.entity.Travel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DateDTO {
 /*   @JsonFormat(pattern = "yyyy-MM-dd")*/
    private String startDate;
  /*  @JsonFormat(pattern = "yyyy-MM-dd")*/
    private String endDate;

}
