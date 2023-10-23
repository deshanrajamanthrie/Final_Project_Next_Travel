package lk.ijse.gdse.user.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lk.ijse.gdse.user.entity.User;
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
