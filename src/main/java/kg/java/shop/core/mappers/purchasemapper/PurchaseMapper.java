package kg.java.shop.core.mappers.purchasemapper;

import kg.java.shop.core.models.dtos.buyer.BuyerSearchDataDto;
import kg.java.shop.core.models.dtos.product.ProductSearchDataDto;
import kg.java.shop.core.models.dtos.purchase.CreatedPurchaseDto;
import kg.java.shop.core.models.dtos.purchase.PurchaseDto;
import kg.java.shop.core.models.dtos.purchase.UpdatedPurchaseDto;
import kg.java.shop.core.models.entity.Purchase;

public class PurchaseMapper {
    public PurchaseDto toDomain(Purchase model) {
        var buyer = model.getBuyer();
        var product = model.getProduct();
        return PurchaseDto.builder()
                .id(model.getId())
                .datePurchase(model.getDatePurchase())
                .product(ProductSearchDataDto.builder()
                        .name(product.getName())
                        .cost(product.getCost())
                        .build())
                .buyer(BuyerSearchDataDto.builder()
                        .firstName(buyer.getFirstName())
                        .lastName(buyer.getLastName())
                        .build())
                .build();
    }

    public Purchase fromDomain(CreatedPurchaseDto model){
        return Purchase.builder()
                .datePurchase(model.getDatePurchase())
                .build();
    }
    public Purchase fromDomain(UpdatedPurchaseDto model){
        return Purchase.builder()
                .datePurchase(model.getDatePurchase())
                .build();
    }
}
