package kg.java.shop.core.models.dtos.buyer;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CreatedBuyerDto {
    private String firstName;
    private String lastName;
}
