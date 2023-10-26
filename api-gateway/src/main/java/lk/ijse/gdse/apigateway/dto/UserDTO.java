package lk.ijse.gdse.apigateway.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {
    private long id;
    private String name;
    private String nic;
    private String address;
    private String email;
    private String password;
    private List<BookingDTO> bookings;

}
