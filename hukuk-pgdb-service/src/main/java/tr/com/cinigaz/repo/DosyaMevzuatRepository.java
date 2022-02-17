package tr.com.cinigaz.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.cinigaz.entity.BorcEntity;
import tr.com.cinigaz.entity.DosyaMevzuatEntity;

@Repository
public interface DosyaMevzuatRepository extends JpaRepository<DosyaMevzuatEntity,Long> {


}
