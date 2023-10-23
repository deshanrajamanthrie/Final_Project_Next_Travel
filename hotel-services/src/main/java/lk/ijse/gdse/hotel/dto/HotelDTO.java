package lk.ijse.gdse.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelDTO {
    private String id;

    private String name;

    private int starRate;


    private String location;


    private List<ContactDTO> contacts;

    private String pets;


    private double  op1;


    private double op2;


    private double op3;

    private double op4;


}
