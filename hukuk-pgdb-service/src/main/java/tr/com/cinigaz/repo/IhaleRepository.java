package tr.com.cinigaz.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.cinigaz.entity.IhaleEntity;
import tr.com.cinigaz.entity.KurumEntity;

@Repository
public interface IhaleRepository extends JpaRepository<IhaleEntity, Long> {

}

