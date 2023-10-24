package lk.ijse.gdse.user.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Booking {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookingId;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private long vehicleId;

    @Column(nullable = false,name = "Guide_OK|Not")
    private String guideId;

    @Column(nullable = false)
    private String travelId;

    @Column(nullable = false)
    private String hotelId;

    @Column(nullable = false,name = "fullPayment")
    private double paid;

    @Column(nullable = false)
    private String paymentStatus;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "user_Id")
    private User user;

}
