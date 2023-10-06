package kg.java.shop.core.models.dtos.purchase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CreatedPurchaseDto {

    private Date datePurchase;
    private Long buyerId;
    private Long productId;

}
