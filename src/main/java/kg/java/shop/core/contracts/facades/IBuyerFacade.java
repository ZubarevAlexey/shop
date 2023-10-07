package kg.java.shop.core.contracts.facades;

import kg.java.shop.core.exceptions.EntityDuplicateExceptions;
import kg.java.shop.core.exceptions.EntityNotFoundException;
import kg.java.shop.core.models.dtos.buyer.*;
import org.springframework.http.HttpStatus;

public interface IBuyerFacade {

    BuyerDto register(CreatedBuyerDto model) throws EntityDuplicateExceptions;
    BuyerDto update(UpdatedBuyerDto model)throws EntityNotFoundException;
    HttpStatus delete(DeleteBuyerDto model) throws EntityNotFoundException;
    BuyerDto getById(FindByIdBuyerDto model) throws EntityNotFoundException;

}
