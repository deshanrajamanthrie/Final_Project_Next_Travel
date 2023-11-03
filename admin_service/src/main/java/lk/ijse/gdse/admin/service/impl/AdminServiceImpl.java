package lk.ijse.gdse.admin.service.impl;

import lk.ijse.gdse.admin.dto.AdminDTO;
import lk.ijse.gdse.admin.entity.Admin;
import lk.ijse.gdse.admin.repo.AdminRepo;
import lk.ijse.gdse.admin.service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepo repo;

    @Autowired
    ModelMapper mapper;

    public AdminDTO saveAdmin(AdminDTO dto) {
        if (repo.existsById(dto.getId())) {
            throw new RuntimeException("Password Has been Already Added!");
        } else {
            repo.save(mapper.map(dto, Admin.class));
        }
        return dto;
    }

    public AdminDTO updateAdmin(AdminDTO dto) {
        if (repo.existsById(dto.getId())) {
            throw new RuntimeException("Password Has been Already Added!");
        } else {
            repo.save(mapper.map(dto, Admin.class));
        }
        return dto;
    }

    public AdminDTO getAdmin(String email) {
        Admin byEmail = repo.findByEmail(email);
        return mapper.map(byEmail, AdminDTO.class);
    }





}
