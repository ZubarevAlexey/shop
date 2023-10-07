package kg.java.shop.domain.services;

import kg.java.shop.core.contracts.services.IBuyerService;
import kg.java.shop.core.exceptions.EntityDuplicateExceptions;
import kg.java.shop.core.exceptions.EntityNotFoundException;
import kg.java.shop.core.mappers.BuyerMapper;
import kg.java.shop.core.models.dtos.buyer.*;
import kg.java.shop.data.repo.BuyerRepository;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BuyerService implements IBuyerService {

    private BuyerMapper buyerMapper;
    private final BuyerRepository buyerRepository;

    public BuyerService(BuyerMapper buyerMapper, BuyerRepository buyerRepository) {
        this.buyerMapper = buyerMapper;
        this.buyerRepository = buyerRepository;
    }

    @Override
    public BuyerDto register(CreatedBuyerDto model) throws  EntityDuplicateExceptions {
        var buyer = buyerRepository.findBuyerEntitiesByFirstName(model.getFirstName());
        if (buyer.isPresent())throw new EntityDuplicateExceptions();
        var entity = buyerRepository.save(buyerMapper.fromDomain(model));
        return buyerMapper.toDomain(entity);
    }

    @Override
    public BuyerDto update(UpdatedBuyerDto model) throws EntityNotFoundException {
        var buyer = buyerRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        var entity =buyer.toBuilder()
                .id(model.getId())
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .build();
        buyerRepository.save(entity);
        return buyerMapper.toDomain(entity);
    }

    @Override
    public HttpStatus delete(DeleteBuyerDto model) throws EntityNotFoundException {
        var buyer = buyerRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        buyerRepository.deleteById(buyer.getId());
        return HttpStatus.OK;
    }

    @Override
    public BuyerDto getById(FindByIdBuyerDto model) throws EntityNotFoundException {
        var buyer = buyerRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        return buyerMapper.toDomain(buyer);
    }
}
