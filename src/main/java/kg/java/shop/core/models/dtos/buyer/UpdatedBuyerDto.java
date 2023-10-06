package kg.java.shop.core.models.dtos.buyer;

import kg.java.shop.core.models.dtos.base.BaseDto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UpdatedBuyerDto extends BaseDto {
    private String firstName;
    private String lastName;
}
