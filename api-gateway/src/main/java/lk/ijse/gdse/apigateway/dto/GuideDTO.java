package lk.ijse.gdse.apigateway.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class GuideDTO {
    private String id;
    private String name;
    private String nic;
    private int num1;
    private String address;
    private double value;
}
