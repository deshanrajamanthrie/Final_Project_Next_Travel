package lk.ijse.gdse.hotel.entity;

import jakarta.persistence.*;
import lk.ijse.gdse.hotel.entity.embeded.Contact;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Hotel {
    @Id
    @Column(name = "hotel_Id",length = 20)
    private String id;

    @Column(name = "hotel_Name")
    private String name;

    private int starRate;

    @Column(nullable = false,length = 45)
    private String location;

    @ElementCollection
    @JoinTable(
            name = "contact_Table",
            joinColumns = @JoinColumn(name = "hotel_Id")
    )
    private List<Contact>contacts;

    @Column(name = "pets Allow")
    private String pets;

    @Column(name = "Opt-1(LKR)")
    private double  op1;

    @Column(name = "Opt-2(LKR)")
    private double op2;

    @Column(name = "Opt-3(LKR)")
    private double op3;

    @Column(name = "Opt-4(LKR)")
    private double op4;

}
