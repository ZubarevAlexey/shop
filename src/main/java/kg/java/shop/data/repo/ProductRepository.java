package kg.java.shop.data.repo;

import kg.java.shop.core.models.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    Optional<ProductEntity> findByName(String name);
}
