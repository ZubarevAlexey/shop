package kg.java.shop.core.models.dtos.product;

import kg.java.shop.core.models.dtos.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UpdatedProductDto extends BaseDto {
    private String name;
    private Long cost;
}
