package kg.java.shop.data.repo;

import kg.java.shop.core.models.entities.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PurchaseRepository extends JpaRepository<PurchaseEntity,Long> {



}
