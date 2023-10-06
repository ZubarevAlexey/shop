package kg.java.shop.core.models.dtos.product;

import kg.java.shop.core.models.dtos.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class DeleteProductDto extends BaseDto {
}
