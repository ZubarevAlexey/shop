package kg.java.shop.core.models.dtos.buyer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@AllArgsConstructor
@Builder(toBuilder = true)
public class BuyerSearchDataDto {
    private String firstName;
    private String lastName;
}
