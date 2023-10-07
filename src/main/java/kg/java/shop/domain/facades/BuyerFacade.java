package kg.java.shop.domain.facades;

import kg.java.shop.core.contracts.facades.IBuyerFacade;
import kg.java.shop.core.contracts.services.IBuyerService;
import kg.java.shop.core.exceptions.EntityDuplicateExceptions;
import kg.java.shop.core.exceptions.EntityNotFoundException;
import kg.java.shop.core.models.dtos.buyer.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class BuyerFacade implements IBuyerFacade {

    private final IBuyerService buyerService;

    public BuyerFacade(IBuyerService buyerService) {
        this.buyerService = buyerService;
    }

    @Override
    public BuyerDto register(CreatedBuyerDto model) throws EntityDuplicateExceptions {
        return buyerService.register(model);
    }

    @Override
    public BuyerDto update(UpdatedBuyerDto model) throws EntityNotFoundException {
        return buyerService.update(model);
    }

    @Override
    public HttpStatus delete(DeleteBuyerDto model) throws EntityNotFoundException {
        return buyerService.delete(model);
    }

    @Override
    public BuyerDto getById(FindByIdBuyerDto model) throws EntityNotFoundException {
        return buyerService.getById(model);
    }
}
