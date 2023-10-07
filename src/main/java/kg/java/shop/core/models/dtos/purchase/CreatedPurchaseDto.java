package kg.java.shop.core.models.dtos.purchase;

import kg.java.shop.core.models.dtos.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CreatedPurchaseDto extends BaseDto {

    private Date datePurchase;
    private Long buyerId;
    private Long productId;

}
