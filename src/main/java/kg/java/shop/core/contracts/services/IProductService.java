package kg.java.shop.core.contracts.services;

import kg.java.shop.core.exceptions.EntityDuplicateExceptions;
import kg.java.shop.core.exceptions.EntityNotFoundException;
import kg.java.shop.core.models.dtos.buyer.DeleteBuyerDto;
import kg.java.shop.core.models.dtos.buyer.FindByIdBuyerDto;
import kg.java.shop.core.models.dtos.product.*;
import org.springframework.http.HttpStatus;

public interface IProductService {

    ProductDto register (CreatedProductDto model) throws EntityDuplicateExceptions, EntityNotFoundException;

    ProductDto update(UpdatedProductDto model) throws EntityNotFoundException;
    HttpStatus delete(DeleteProductDto model) throws EntityNotFoundException;
    ProductDto getById(FindByIdProductDto model) throws EntityNotFoundException;
}
