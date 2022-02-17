package tr.com.cinigaz.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.cinigaz.entity.BorcDetayEntity;
@Repository
public interface BorcDetayRepository extends JpaRepository<BorcDetayEntity,Long> {
}
