package kg.java.shop.core.models.dtos.buyer;

import lombok.*;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class BuyerSearchDataDto {
    private String firstName;
    private String lastName;
}
