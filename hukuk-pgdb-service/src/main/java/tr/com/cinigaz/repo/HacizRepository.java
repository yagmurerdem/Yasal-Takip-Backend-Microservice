package tr.com.cinigaz.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.cinigaz.entity.HacizEntity;

@Repository
public interface HacizRepository extends JpaRepository<HacizEntity, Long> {
}