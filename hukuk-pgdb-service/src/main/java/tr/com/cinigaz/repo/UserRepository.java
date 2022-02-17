package tr.com.cinigaz.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tr.com.cinigaz.entity.UserEntity;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long>
{	
    public Optional<UserEntity> findByusername(String username);
   // public Optional<UserEntity> findByemail(String email);
    String SQL = "Select * From Kullanici Where email = :p";
    UserEntity findByEmail(String email);
}
