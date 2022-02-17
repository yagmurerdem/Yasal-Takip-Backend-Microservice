package tr.com.cinigaz.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.cinigaz.entity.MahkemeEntity;

@Repository
public interface MahkemeRepsitory extends JpaRepository<MahkemeEntity,Long> {
}
