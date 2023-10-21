package lk.ijse.gdse.user.service.impl;

import lk.ijse.gdse.user.dto.UserDTO;
import lk.ijse.gdse.user.entity.User;
import lk.ijse.gdse.user.repo.UserRepo;
import lk.ijse.gdse.user.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Stream;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo repo;

    @Autowired
    ModelMapper mapper;


    public UserDTO saveUser(UserDTO dto) {
        repo.save(mapper.map(dto, User.class));
        return dto;
    }


    public UserDTO updateUser(UserDTO dto) {
        repo.save(mapper.map(dto, User.class));
        return dto;
    }


    public List<UserDTO> getAllUser() {
        return mapper.map(repo.findAll(), new TypeToken<List<UserDTO>>() {
        }.getType());
    }


    public UserDTO searchUser(Long id) {
        if(!repo.existsById(id)){
            throw  new RuntimeException("User Not Found!");
        }
        return mapper.map(repo.findById(id).get(), UserDTO.class);
    }

    public void deleteUser(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("User Not Found!");
        } else {
            repo.delete(repo.findById(id).get());

        }
    }

    public UserDTO searchUserName(String name) {
        return mapper.map(repo.readUserByName(name), UserDTO.class);
    }


}
