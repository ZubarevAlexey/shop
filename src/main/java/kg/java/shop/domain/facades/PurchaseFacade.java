package kg.java.shop.domain.facades;

import kg.java.shop.core.contracts.facades.IPurchaseFacade;
import kg.java.shop.core.contracts.services.IPurchaseService;
import kg.java.shop.core.exceptions.EntityDuplicateExceptions;
import kg.java.shop.core.exceptions.EntityNotFoundException;
import kg.java.shop.core.models.dtos.purchase.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PurchaseFacade implements IPurchaseFacade {

    private final IPurchaseService purchaseService;

    public PurchaseFacade(IPurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @Override
    public PurchaseDto register(CreatedPurchaseDto model) throws EntityDuplicateExceptions, EntityNotFoundException {
        return purchaseService.register(model);
    }

    @Override
    public PurchaseDto update(UpdatedPurchaseDto model) throws EntityNotFoundException {
        return purchaseService.update(model);
    }

    @Override
    public HttpStatus delete(DeletePurchaseDto model) throws EntityNotFoundException {
        return purchaseService.delete(model);
    }

    @Override
    public PurchaseDto getById(FindByIdPurchaseDto model) throws EntityNotFoundException {
        return purchaseService.getById(model);
    }
}
