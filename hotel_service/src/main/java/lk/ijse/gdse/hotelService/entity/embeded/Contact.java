package lk.ijse.gdse.hotelService.entity.embeded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Contact {
    @Column(nullable = false,length = 45)
    private String email;

    @Column(nullable = false,length = 45)
    private int contactNum1;

    @Column(nullable = false,length = 45)
    private int contactNum2;

}
