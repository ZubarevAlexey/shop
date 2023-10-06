package kg.java.shop.core.mappers.buyermapper;

import kg.java.shop.core.models.dtos.buyer.BuyerDto;
import kg.java.shop.core.models.dtos.buyer.CreatedBuyerDto;
import kg.java.shop.core.models.dtos.buyer.UpdatedBuyerDto;
import kg.java.shop.core.models.entity.Buyer;

public class BuyerMapper {

    public BuyerDto toDomain(Buyer model){
        return BuyerDto.builder()
                .id(model.getId())
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .build();
    }


    public Buyer fromDomain(CreatedBuyerDto model){
        return Buyer.builder()
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .build();
    }
    public Buyer fromDomain(UpdatedBuyerDto model){
        return Buyer.builder()
                .id(model.getId())
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .build();
    }
}
