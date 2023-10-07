package kg.java.shop.core.mappers;

import kg.java.shop.core.models.dtos.product.CreatedProductDto;
import kg.java.shop.core.models.dtos.product.ProductDto;
import kg.java.shop.core.models.dtos.product.UpdatedProductDto;
import kg.java.shop.core.models.entities.ProductEntity;

public class ProductMapper {

    public ProductDto toDomain(ProductEntity model){
        return ProductDto.builder()
                .id(model.getId())
                .name(model.getName())
                .cost(model.getCost())
                .build();
    }
    public ProductEntity fromDomain(CreatedProductDto model){
        return ProductEntity.builder()
                .name(model.getName())
                .cost(model.getCost())
                .build();
    }
    public ProductEntity fromDomain(UpdatedProductDto model){
        return ProductEntity.builder()
                .id(model.getId())
                .name(model.getName())
                .cost(model.getCost())
                .build();
    }

}
