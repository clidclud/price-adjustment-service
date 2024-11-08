package ru.panov.productpricing.price_adjustment_service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceAdjustmentServiceTest {

    private PriceAdjustmentService priceAdjustmentService;

    @BeforeEach
    void setUp() {
        priceAdjustmentService = new PriceAdjustmentService();
    }

    @Test
    void testAdjustPrices() {
        // Подготовим тестовые данные
        Product product1 = new Product(1L, "Product 1", 100.0);
        Product product2 = new Product(2L, "Product 2", 150.0);
        List<Product> products = Arrays.asList(product1, product2);

        // Применяем изменение цен на 10%
        double percent = 10.0;
        List<Product> adjustedProducts = priceAdjustmentService.adjustPrices(products, percent);

        // Проверяем, что цены были корректно пересчитаны
        assertEquals(110.0, adjustedProducts.get(0).getPrice(), 0.01);
        assertEquals(165.0, adjustedProducts.get(1).getPrice(), 0.01);
    }
}
