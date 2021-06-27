package co.com.prueba.nexus.repository;

import co.com.prueba.nexus.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

    @Query("Select user from User user where user.userName= :userName")
    public Optional<User> findByName(String userName);
}
