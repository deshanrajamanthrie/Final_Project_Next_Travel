package lk.ijse.gdse.travelService.service.impl;

import lk.ijse.gdse.travelService.dto.PackageCategoryDTO;
import lk.ijse.gdse.travelService.entity.PackageCategory;
import lk.ijse.gdse.travelService.repo.PackageCategoryRepo;
import lk.ijse.gdse.travelService.service.PackageCategoryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PackageCategoryServiceImpl implements PackageCategoryService {

    @Autowired
    PackageCategoryRepo repo;

    @Autowired
    ModelMapper mapper;

    public PackageCategoryDTO savePackageCategory(PackageCategoryDTO dto) {
        if (repo.existsById(dto.getId())) {
            throw new RuntimeException("PackageCategory is all ready Added");
        } else {
           repo.save(mapper.map(dto, PackageCategory.class));
        }
        return dto;
    }

    public List<PackageCategoryDTO> getAllCategory() {
        List<PackageCategory> all = repo.findAll();
        for (PackageCategory pack : all) {
            System.out.println(pack);
            pack.setTravels(null);
        }

        return mapper.map(all, new TypeToken<List<PackageCategoryDTO>>() {
        }.getType());
    }

    public PackageCategoryDTO updatePackageCategory(PackageCategoryDTO dto) {
        if (!repo.existsById(dto.getId())) {
            throw new RuntimeException("Package Category is Not Found");
        } else {
            repo.save(mapper.map(dto, PackageCategory.class));
        }
        return dto;
    }

    public PackageCategoryDTO searchPackageCategory(String id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Package Category Not Found!");
        } else {
            PackageCategory packageCategory = repo.findById(id).get();
          packageCategory.setTravels(null);
            return mapper.map(packageCategory, PackageCategoryDTO.class);
        }
    }

    public void deletePackageCategory(String id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Package Category Not Found!");
        } else {
            repo.delete(repo.findById(id).get());
        }
    }


}
