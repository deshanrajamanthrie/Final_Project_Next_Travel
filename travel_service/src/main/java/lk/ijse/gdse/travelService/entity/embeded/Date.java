package lk.ijse.gdse.travelService.entity.embeded;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.NoRepositoryBean;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class Date {
    private String startDate;
    private String endDate;

}
