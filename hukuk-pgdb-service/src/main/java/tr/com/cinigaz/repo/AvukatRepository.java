package tr.com.cinigaz.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tr.com.cinigaz.entity.AvukatEntity;



@Repository
public interface AvukatRepository extends JpaRepository<AvukatEntity,Integer> {
    String SQL = "Select * From avukat where sicil_no = :s";
    @Query(value = SQL, nativeQuery = true)
    public AvukatEntity getBySicilNo(@Param(value = "s") Integer sicilNo);
}
