package lk.ijse.gdse.user.repo;

import lk.ijse.gdse.user.dto.UserDTO;
import lk.ijse.gdse.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User,Long> {

     User readUserByName(String name);

     User findUserByEmail(String email);

}
