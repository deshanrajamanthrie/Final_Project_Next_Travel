package lk.ijse.gdse.travelService.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lk.ijse.gdse.travelService.entity.embeded.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "select_Travel_Table")
public class Travel {
    @Id
    @Column(name = "travel_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,length = 45)
    private String travelArea;

    @ElementCollection(fetch = FetchType.LAZY)
    @JoinTable(
            name = "Travel_Duration",
            joinColumns = @JoinColumn(name = "travel_Id")
    )
    private Collection<Date>dates;

    @Column(nullable = false,length = 45)
    private int countDays;


    @Column(name = "guide Yes|No")
    private String guide;

    @Column(name = "No Of Child")
    private int noChildren;


    @Column(name = "No Of Adult")
    private int noAdult;

    private int headCount;

    @Column(nullable = false,length = 45)
    private double paidValue;


    @ManyToOne
    @JoinColumn(name = "package_category_Id")
    private PackageCategory packageCategory;





}
