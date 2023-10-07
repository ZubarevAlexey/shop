package kg.java.shop.core.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "product", schema = "public", catalog = "postgres")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Builder(toBuilder = true)
public class ProductEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private Long cost;

    @OneToMany(mappedBy= "product")
    @JsonIgnore
    private Set<PurchaseEntity> purchases = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity product = (ProductEntity) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(cost, product.cost) && Objects.equals(purchases, product.purchases);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cost, purchases);
    }

    @Override
    public String toString() {
        return name;
    }
}
