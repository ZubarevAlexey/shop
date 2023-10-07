package kg.java.shop.data.repo;

import kg.java.shop.core.models.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer,Long> {
}
