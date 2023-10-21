package lk.ijse.gdse.user.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private long id;
    private String name;
    private String nic;
    private String address;
    private String email;
    private String password;
}
