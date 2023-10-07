package kg.java.shop.core.contracts.facades;

import kg.java.shop.core.exceptions.EntityDuplicateExceptions;
import kg.java.shop.core.exceptions.EntityNotFoundException;
import kg.java.shop.core.models.dtos.product.*;
import kg.java.shop.core.models.dtos.purchase.*;
import org.springframework.http.HttpStatus;

public interface IPurchaseFacade {
    PurchaseDto register(CreatedPurchaseDto model) throws EntityDuplicateExceptions, EntityNotFoundException;

    PurchaseDto update(UpdatedPurchaseDto model) throws EntityNotFoundException;

    HttpStatus delete(DeletePurchaseDto model) throws EntityNotFoundException;

    PurchaseDto getById(FindByIdPurchaseDto model) throws EntityNotFoundException;
}
