package kg.java.shop.core.models.dtos.purchase;

import kg.java.shop.core.models.dtos.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class DeletePurchaseDto extends BaseDto {
}
