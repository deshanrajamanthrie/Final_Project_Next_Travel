package lk.ijse.gdse.travelService.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PackageCategory {
    @Id
    @Column(name = "package_category_Id")
    private String id;
    private String category;

    @ToString.Exclude
    @OneToMany(mappedBy = "packageCategory",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Travel>travels;


    public PackageCategory(String id, String category) {
        this.id = id;
        this.category = category;
    }
}
