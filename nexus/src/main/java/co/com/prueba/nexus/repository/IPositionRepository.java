package co.com.prueba.nexus.repository;

import co.com.prueba.nexus.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPositionRepository extends JpaRepository<Position,Integer> {

    @Query("Select position from Position position where position.positionName= :positionName")
    public Optional<Position> findByName(String positionName);
}
