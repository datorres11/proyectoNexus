package co.com.prueba.nexus.repository;

import co.com.prueba.nexus.entity.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICommodityRepository extends JpaRepository<Commodity, Integer> {

    @Query("Select commodity from Commodity commodity where commodity.productName= :productName")
    public Optional<Commodity> findByName(String productName);
}
