package tr.com.cinigaz.repo;

import tr.com.cinigaz.entity.BorcEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface BorcRepositoy extends JpaRepository<BorcEntity,Integer> {


}
