package kg.java.shop.core.mappers.productmapper;

import kg.java.shop.core.models.dtos.product.CreatedProductDto;
import kg.java.shop.core.models.dtos.product.ProductDto;
import kg.java.shop.core.models.dtos.product.UpdatedProductDto;
import kg.java.shop.core.models.entity.Product;

public class ProductMapper {

    public ProductDto toDomain(Product model){
        return ProductDto.builder()
                .id(model.getId())
                .name(model.getName())
                .cost(model.getCost())
                .build();
    }
    public Product fromDomain(CreatedProductDto model){
        return Product.builder()
                .name(model.getName())
                .cost(model.getCost())
                .build();
    }
    public Product fromDomain(UpdatedProductDto model){
        return Product.builder()
                .id(model.getId())
                .name(model.getName())
                .cost(model.getCost())
                .build();
    }

}
