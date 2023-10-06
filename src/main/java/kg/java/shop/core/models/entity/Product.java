package kg.java.shop.core.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private Long cost;

    @OneToMany(mappedBy= "product")
    @JsonIgnore
    private Set<Purchase> purchases = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
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
