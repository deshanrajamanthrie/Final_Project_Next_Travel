package lk.ijse.gdse.user.service;

import lk.ijse.gdse.user.dto.UserDTO;
import lk.ijse.gdse.user.entity.User;
import org.modelmapper.TypeToken;

import java.util.List;

public interface UserService {

    UserDTO saveUser(UserDTO dto);

    UserDTO updateUser(UserDTO dto);


    List<UserDTO> getAllUser();


    UserDTO searchUser(Long id);

    void deleteUser(Long id);

    UserDTO searchUserName(String name);

    UserDTO searchUserEmail(String email);


}
