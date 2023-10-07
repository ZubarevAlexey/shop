package kg.java.shop.domain.services;

import kg.java.shop.core.contracts.services.IPurchaseService;
import kg.java.shop.core.exceptions.EntityDuplicateExceptions;
import kg.java.shop.core.exceptions.EntityNotFoundException;
import kg.java.shop.core.mappers.BuyerMapper;
import kg.java.shop.core.mappers.PurchaseMapper;
import kg.java.shop.core.models.dtos.purchase.*;
import kg.java.shop.data.repo.BuyerRepository;
import kg.java.shop.data.repo.ProductRepository;
import kg.java.shop.data.repo.PurchaseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PurchaseService implements IPurchaseService {
    private PurchaseMapper purchaseMapper;
    private final ProductRepository productRepository;

    private final BuyerRepository buyerRepository;

    private final PurchaseRepository purchaseRepository;

    public PurchaseService(PurchaseMapper purchaseMapper, ProductRepository productRepository,
                           BuyerRepository buyerRepository, PurchaseRepository purchaseRepository) {
        this.purchaseMapper = purchaseMapper;
        this.productRepository = productRepository;
        this.buyerRepository = buyerRepository;
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public PurchaseDto register(CreatedPurchaseDto model) throws EntityNotFoundException, EntityDuplicateExceptions {
        var purchase = purchaseRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        var buyer = buyerRepository.findById(model.getBuyerId()).orElseThrow(EntityNotFoundException::new);
        var product = productRepository.findById(model.getProductId()).orElseThrow(EntityNotFoundException::new);
        var entity = purchaseMapper.fromDomain(model);
        entity.setProduct(product);
        entity.setBuyer(buyer);
        entity = purchaseRepository.save(entity);
        return purchaseMapper.toDomain(entity);
    }

    @Override
    public PurchaseDto update(UpdatedPurchaseDto model) throws EntityNotFoundException {
        var purchase = purchaseRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        var buyer = buyerRepository.findById(model.getBuyerId()).orElseThrow(EntityNotFoundException::new);
        var product = productRepository.findById(model.getProductId()).orElseThrow(EntityNotFoundException::new);
        var entity = purchase.toBuilder()
                .id(model.getId())
                .datePurchase(model.getDatePurchase())
                .buyer(buyer)
                .product(product)
                .build();
        purchaseRepository.save(entity);
        return purchaseMapper.toDomain(entity);
    }

    @Override
    public HttpStatus delete(DeletePurchaseDto model) throws EntityNotFoundException {
        var purchase = purchaseRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        purchaseRepository.deleteById(purchase.getId());
        return HttpStatus.OK;
    }

    @Override
    public PurchaseDto getById(FindByIdPurchaseDto model) throws EntityNotFoundException {
        var purchase = purchaseRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        return purchaseMapper.toDomain(purchase);
    }
}
