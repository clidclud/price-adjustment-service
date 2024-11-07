package ru.panov.productpricing.price_adjustment_service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class PriceAdjustmentService {

    public List<Product> adjustPrices(List<Product> products, double percent) {
        for (Product product : products) {
            double newPrice = product.getPrice() * (1 + percent / 100);
            BigDecimal roundedPrice = BigDecimal.valueOf(newPrice).setScale(2, RoundingMode.HALF_UP);
            product.setPrice(roundedPrice.doubleValue());
        }
        return products;
    }
}
