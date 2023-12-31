package kg.java.shop.core.models.entities;

import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "purchase", schema = "public", catalog = "postgres")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Builder(toBuilder = true)
public class PurchaseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "date_purchase")
    private Date datePurchase;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "buyer_id", referencedColumnName = "id")
    private BuyerEntity buyer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseEntity purchase = (PurchaseEntity) o;
        return Objects.equals(id, purchase.id) && Objects.equals(datePurchase, purchase.datePurchase)
                && Objects.equals(product, purchase.product) && Objects.equals(purchase, purchase.buyer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, datePurchase, product, buyer

        );
    }

}
