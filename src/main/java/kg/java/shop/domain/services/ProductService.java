package kg.java.shop.domain.services;

import kg.java.shop.core.contracts.services.IProductService;
import kg.java.shop.core.exceptions.EntityDuplicateExceptions;
import kg.java.shop.core.exceptions.EntityNotFoundException;
import kg.java.shop.core.mappers.ProductMapper;
import kg.java.shop.core.models.dtos.product.*;
import kg.java.shop.data.repo.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductService implements IProductService {

    private ProductMapper productMapper;
    private final ProductRepository productRepository;

    public ProductService(ProductMapper productMapper, ProductRepository productRepository) {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto register(CreatedProductDto model) throws EntityDuplicateExceptions, EntityNotFoundException {
        var product = productRepository.findByName(model.getName());
        if (product.isPresent())throw new EntityDuplicateExceptions();
        var entity = productRepository.save(productMapper.fromDomain(model));
        return productMapper.toDomain(entity);
    }

    @Override
    public ProductDto update(UpdatedProductDto model) throws EntityNotFoundException {
        var product = productRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        var entity = product.toBuilder()
                .id(model.getId())
                .name(model.getName())
                .cost(model.getCost())
                .build();
        productRepository.save(entity);
        return productMapper.toDomain(entity);
    }

    @Override
    public HttpStatus delete(DeleteProductDto model) throws EntityNotFoundException {
        var product = productRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        productRepository.deleteById(product.getId());
        return HttpStatus.OK;
    }

    @Override
    public ProductDto getById(FindByIdProductDto model) throws EntityNotFoundException {
        var product = productRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        return productMapper.toDomain(product);
    }
}
