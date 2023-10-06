package kg.java.shop.core.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Builder(toBuilder = true)
public class Buyer {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;


    @OneToMany(mappedBy = "buyer")
    @JsonIgnore
    private Set<Purchase> purchases = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Buyer buyer = (Buyer) o;
        return Objects.equals(id, buyer.id) && Objects.equals(firstName, buyer.firstName) && Objects.equals(lastName, buyer.lastName) && Objects.equals(purchases, buyer.purchases);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, purchases);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
