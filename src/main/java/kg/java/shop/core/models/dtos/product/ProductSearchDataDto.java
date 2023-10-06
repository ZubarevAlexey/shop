package kg.java.shop.core.models.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class ProductSearchDataDto {
    private String name;
    private Long cost;
}
