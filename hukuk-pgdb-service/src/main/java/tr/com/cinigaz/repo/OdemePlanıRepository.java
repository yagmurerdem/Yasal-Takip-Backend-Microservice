package tr.com.cinigaz.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.cinigaz.entity.OdemePlanıEntity;


@Repository
public interface OdemePlanıRepository extends JpaRepository<OdemePlanıEntity,Long> {


}
