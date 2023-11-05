package lk.ijse.gdse.admin.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.repository.NoRepositoryBean;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;
}
