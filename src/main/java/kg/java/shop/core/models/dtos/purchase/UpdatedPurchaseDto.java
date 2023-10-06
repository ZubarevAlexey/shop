package kg.java.shop.core.models.dtos.purchase;

import kg.java.shop.core.models.dtos.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class UpdatedPurchaseDto extends BaseDto {
    private Date datePurchase;
    private Long buyerId;
    private Long productId;
}
