package kg.java.shop.controllers.v1;

import kg.java.shop.core.contracts.facades.IBuyerFacade;
import kg.java.shop.core.exceptions.EntityDuplicateExceptions;
import kg.java.shop.core.exceptions.EntityNotFoundException;
import kg.java.shop.core.models.dtos.buyer.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bueyr")
public class BuyerV1Controller {

    private final IBuyerFacade buyerFacade;

    public BuyerV1Controller(IBuyerFacade buyerFacade) {
        this.buyerFacade = buyerFacade;
    }

    @PostMapping("/signup")
    public ResponseEntity<BuyerDto> register(@RequestBody CreatedBuyerDto model){
        try {
            return ResponseEntity.ok(buyerFacade.register(model));
        }
        catch (EntityDuplicateExceptions e){
            return ResponseEntity.badRequest().build();
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/update")
    public ResponseEntity<BuyerDto> update(@RequestBody UpdatedBuyerDto model){
        try {
            return ResponseEntity.ok(buyerFacade.update(model));
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/delete")
    public ResponseEntity<HttpStatus> delete(@RequestBody DeleteBuyerDto model){
        try {
            return ResponseEntity.ok(buyerFacade.delete(model));
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/id")
    public ResponseEntity<BuyerDto> getById(@RequestBody FindByIdBuyerDto model){
        try {
            return ResponseEntity.ok(buyerFacade.getById(model));
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
