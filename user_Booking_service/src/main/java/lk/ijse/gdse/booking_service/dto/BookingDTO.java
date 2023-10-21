package lk.ijse.gdse.booking_service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingDTO {
    private long bookingId;

 /*  @JsonFormat(pattern = "yyyy-MM-dd")*/
    private String date;

    private long vehicleId;

    private long userid;

    private String guideId;

    private String travelId;

    private String hotelId;

    private double paid;

    private String paymentStatus;
}
