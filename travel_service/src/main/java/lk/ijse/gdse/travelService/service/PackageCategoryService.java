package lk.ijse.gdse.travelService.service;

import lk.ijse.gdse.travelService.dto.PackageCategoryDTO;
import lk.ijse.gdse.travelService.entity.PackageCategory;
import lk.ijse.gdse.travelService.repo.PackageCategoryRepo;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PackageCategoryService {
     PackageCategoryDTO savePackageCategory(PackageCategoryDTO dto);

     List<PackageCategoryDTO> getAllCategory();

     PackageCategoryDTO updatePackageCategory(PackageCategoryDTO dto);

     PackageCategoryDTO searchPackageCategory(String id);

     void deletePackageCategory(String id);


}
