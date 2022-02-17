package tr.com.cinigaz.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.cinigaz.entity.OdemeEntity;
@Repository
public interface OdemeRepository extends JpaRepository<OdemeEntity,Long> {

}
