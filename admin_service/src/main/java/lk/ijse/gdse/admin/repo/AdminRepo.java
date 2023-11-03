package lk.ijse.gdse.admin.repo;

import lk.ijse.gdse.admin.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin,Long> {

   Admin findByEmail(String email);
}
