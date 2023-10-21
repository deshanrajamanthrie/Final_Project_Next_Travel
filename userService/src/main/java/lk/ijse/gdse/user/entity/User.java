package lk.ijse.gdse.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@Entity(name = "user_Table")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_Id")
    private long id;

    @Column(name = "userName")
    private String name;
    private String nic;
    private String address;

    @Column(nullable = false,length = 45)
    private String email;
    @Column(nullable = false,length = 45)
    private String password;


    /*public  User(){
        UserIdGenerator uuid = new UserIdGenerator();
        Serializable generate = uuid.generate();
        this.userId=generate.toString();
    }*/



}
