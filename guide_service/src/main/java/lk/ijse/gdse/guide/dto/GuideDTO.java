package lk.ijse.gdse.guide.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GuideDTO {
    private String id;
    private String name;
    private String nic;
    private int num1;
    private String address;
    private double value;
}
