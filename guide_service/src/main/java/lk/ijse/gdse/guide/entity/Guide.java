package lk.ijse.gdse.guide.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "guide_table")
public class Guide {
    @Id
    @Column(name = "guide_Id",nullable = false)
    private String id;
    @Column(name = "guide_Name")
    private String name;
    private String nic;


    private int num1;


    private String address;
    @Column(name = "payment",nullable = false)
    private double value;


}
