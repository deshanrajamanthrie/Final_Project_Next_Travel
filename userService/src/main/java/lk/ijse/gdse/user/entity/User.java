package lk.ijse.gdse.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;


@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity(name = "user_Table")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_Id")
    private long id;

    @Column(name = "userName")
    private String name;
    private String nic;
    private String address;

    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    //@JoinColumn(name = "bookingId")
    @Column(name = "booking_Id")
    @ToString.Exclude
    @JsonIgnore
    private List<Booking>bookings;






}
