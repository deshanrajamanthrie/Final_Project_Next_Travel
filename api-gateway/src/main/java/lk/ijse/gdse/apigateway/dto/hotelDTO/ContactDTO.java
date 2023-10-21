package lk.ijse.gdse.apigateway.dto.hotelDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDTO {
    private String email;

    private int contactNum1;

    private int contactNum2;
}
