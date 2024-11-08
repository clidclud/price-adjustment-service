package ru.panov.productpricing.price_adjustment_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final PriceAdjustmentService priceAdjustmentService;

    @Autowired
    public ProductController(PriceAdjustmentService priceAdjustmentService) {
        this.priceAdjustmentService = priceAdjustmentService;
    }

    @PostMapping("/adjust-prices")
    public ResponseEntity<List<Product>> adjustPrices(
            @RequestBody List<Product> products,
            @RequestParam double percent) {
        List<Product> updatedProducts = priceAdjustmentService.adjustPrices(products, percent);
        return ResponseEntity.ok(updatedProducts);
    }
}
