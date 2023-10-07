package kg.java.shop.domain.facades;

import kg.java.shop.core.contracts.facades.IProductFacade;
import kg.java.shop.core.contracts.services.IProductService;
import kg.java.shop.core.exceptions.EntityDuplicateExceptions;
import kg.java.shop.core.exceptions.EntityNotFoundException;
import kg.java.shop.core.models.dtos.product.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ProductFacade implements IProductFacade {
    private final IProductService productService;

    public ProductFacade(IProductService productService) {
        this.productService = productService;
    }

    @Override
    public ProductDto register(CreatedProductDto model) throws EntityDuplicateExceptions, EntityNotFoundException {
        return productService.register(model);
    }

    @Override
    public ProductDto update(UpdatedProductDto model) throws EntityNotFoundException {
        return productService.update(model);
    }

    @Override
    public HttpStatus delete(DeleteProductDto model) throws EntityNotFoundException {
        return productService.delete(model);
    }

    @Override
    public ProductDto getById(FindByIdProductDto model) throws EntityNotFoundException {
        return productService.getById(model);
    }
}
