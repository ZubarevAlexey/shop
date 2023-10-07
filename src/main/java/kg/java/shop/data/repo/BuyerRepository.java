package kg.java.shop.data.repo;

import kg.java.shop.core.models.entities.BuyerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BuyerRepository extends JpaRepository<BuyerEntity,Long> {

    Optional<BuyerEntity> findBuyerEntitiesByFirstName(String firstName);
}
