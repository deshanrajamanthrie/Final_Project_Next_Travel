package lk.ijse.gdse.apigateway.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BookingDTO {
    private long bookingId;

    private String date;

    private long vehicleId;

    private String guideId;

    private String travelId;

    private String hotelId;

    private double paid;

    private String paymentStatus;

    private UserDTO user;
}
