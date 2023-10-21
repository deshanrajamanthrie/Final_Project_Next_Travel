package lk.ijse.gdse.guide.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import lk.ijse.gdse.guide.entity.embeded.Contact;
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
    private Contact num1;
    private Contact email;
    private String address;
    private double value;
}
