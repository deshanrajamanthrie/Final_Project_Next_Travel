package lk.ijse.gdse.admin.service;

import lk.ijse.gdse.admin.dto.AdminDTO;
import lk.ijse.gdse.admin.entity.Admin;
import org.modelmapper.TypeToken;

import java.util.List;

public interface AdminService {
   AdminDTO saveAdmin(AdminDTO dto);

     AdminDTO updateAdmin(AdminDTO dto);

     AdminDTO getAdmin(String email);

     void deleteAdmin(Long id);

   List<AdminDTO> getAllAdmin();


}
