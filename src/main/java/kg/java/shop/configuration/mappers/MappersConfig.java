package kg.java.shop.configuration.mappers;

import kg.java.shop.core.mappers.buyermapper.BuyerMapper;
import kg.java.shop.core.mappers.productmapper.ProductMapper;
import kg.java.shop.core.mappers.purchasemapper.PurchaseMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Column;

@Configuration
public class MappersConfig {
    @Bean
    public BuyerMapper buildBuyerMapper(){
        return new BuyerMapper();
    }

    @Bean
    public ProductMapper buildProductMapper(){
        return new ProductMapper();
    }
    @Bean
    public PurchaseMapper buildPurchaseMapper(){
        return new PurchaseMapper();
    }

}
