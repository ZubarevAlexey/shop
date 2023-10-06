package kg.java.shop.core.models.dtos.purchase;

import kg.java.shop.core.models.dtos.buyer.BuyerSearchDataDto;
import kg.java.shop.core.models.dtos.product.ProductSearchDataDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PurchaseDto {
    private Long id;
    private Date datePurchase;
    private ProductSearchDataDto product;
    private BuyerSearchDataDto buyer;

}
