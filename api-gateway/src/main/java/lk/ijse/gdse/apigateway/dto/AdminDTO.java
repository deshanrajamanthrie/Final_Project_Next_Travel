package lk.ijse.gdse.apigateway.dto;

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
