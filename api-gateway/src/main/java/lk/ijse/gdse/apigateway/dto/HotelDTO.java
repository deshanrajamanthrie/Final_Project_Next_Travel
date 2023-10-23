package lk.ijse.gdse.apigateway.dto;

import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class HotelDTO {
    private String id;

    private String name;

    private int starRate;


    private String location;


    private List<HotelContactDTO> contacts;

    private String pets;


    private double  op1;


    private double op2;


    private double op3;

    private double op4;

}
