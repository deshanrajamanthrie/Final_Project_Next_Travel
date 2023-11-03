package lk.ijse.gdse.admin.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AdminDTO {

    private long id;
    private String userName;
    private String role;

    private String email;
    private String password;
}
