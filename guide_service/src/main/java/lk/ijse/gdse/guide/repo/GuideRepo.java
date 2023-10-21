package lk.ijse.gdse.guide.repo;

import lk.ijse.gdse.guide.entity.Guide;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuideRepo extends JpaRepository<Guide,String> {
}
