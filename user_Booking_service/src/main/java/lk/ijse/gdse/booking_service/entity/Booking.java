package lk.ijse.gdse.booking_service.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "booking_table")
public class Booking {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookingId;

    private String date;

    private long vehicleId;

    private long userid;

    private String guideId;

    private String travelId;

    private String hotelId;

    private double paid;

    private String paymentStatus;

}
