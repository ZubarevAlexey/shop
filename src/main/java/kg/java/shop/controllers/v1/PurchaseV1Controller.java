package kg.java.shop.controllers.v1;

import kg.java.shop.core.contracts.facades.IPurchaseFacade;
import kg.java.shop.core.contracts.services.IPurchaseService;
import kg.java.shop.core.exceptions.EntityDuplicateExceptions;
import kg.java.shop.core.exceptions.EntityNotFoundException;
import kg.java.shop.core.models.dtos.purchase.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/purchase")
public class PurchaseV1Controller {

    private final IPurchaseFacade purchaseFacade;

    public PurchaseV1Controller(IPurchaseFacade purchaseFacade) {
        this.purchaseFacade = purchaseFacade;
    }

    @PostMapping("/add")
    public ResponseEntity<PurchaseDto> add(@RequestBody CreatedPurchaseDto model){
        try {
            return ResponseEntity.ok(purchaseFacade.register(model));
        }
        catch (EntityDuplicateExceptions e){
            return ResponseEntity.internalServerError().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/update")
    public ResponseEntity<PurchaseDto> update(@RequestBody UpdatedPurchaseDto model){
        try {
            return ResponseEntity.ok(purchaseFacade.update(model));
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<HttpStatus> delete(@RequestBody DeletePurchaseDto model){
        try {
            return ResponseEntity.ok(purchaseFacade.delete(model));
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/id")
    public ResponseEntity<PurchaseDto> getById(@RequestBody FindByIdPurchaseDto model){
        try {
            return ResponseEntity.ok(purchaseFacade.getById(model));
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

}
