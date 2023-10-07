package kg.java.shop.core.contracts.services;

import kg.java.shop.core.exceptions.EntityDuplicateExceptions;
import kg.java.shop.core.exceptions.EntityNotFoundException;
import kg.java.shop.core.models.dtos.buyer.*;
import org.springframework.http.HttpStatus;

public interface IBuyerService {

    BuyerDto register(CreatedBuyerDto model) throws EntityDuplicateExceptions,EntityDuplicateExceptions;

    BuyerDto update(UpdatedBuyerDto model) throws EntityNotFoundException;

    HttpStatus delete(DeleteBuyerDto model) throws EntityNotFoundException;

    BuyerDto getById(FindByIdBuyerDto model) throws EntityNotFoundException;
}
