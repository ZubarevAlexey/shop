package kg.java.shop.core.mappers;

import kg.java.shop.core.models.dtos.buyer.BuyerDto;
import kg.java.shop.core.models.dtos.buyer.CreatedBuyerDto;
import kg.java.shop.core.models.dtos.buyer.UpdatedBuyerDto;
import kg.java.shop.core.models.entities.BuyerEntity;

public class BuyerMapper {

    public BuyerDto toDomain(BuyerEntity model){
        return BuyerDto.builder()
                .id(model.getId())
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .build();
    }


    public BuyerEntity fromDomain(CreatedBuyerDto model){
        return BuyerEntity.builder()
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .build();
    }
    public BuyerEntity fromDomain(UpdatedBuyerDto model){
        return BuyerEntity.builder()
                .id(model.getId())
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .build();
    }
}
