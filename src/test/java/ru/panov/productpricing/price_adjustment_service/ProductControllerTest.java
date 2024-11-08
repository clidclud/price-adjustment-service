package ru.panov.productpricing.price_adjustment_service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ProductControllerTest {

    @Mock
    private PriceAdjustmentService priceAdjustmentService;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAdjustPrices() {
        // Подготовим тестовые данные
        Product product1 = new Product(1L, "Product 1", 100.0);
        Product product2 = new Product(2L, "Product 2", 150.0);
        List<Product> products = Arrays.asList(product1, product2);

        // Мокируем сервис
        when(priceAdjustmentService.adjustPrices(products, 10.0)).thenReturn(products);

        // Выполняем запрос к контроллеру
        ResponseEntity<List<Product>> response = productController.adjustPrices(products, 10.0);

        // Проверяем, что ответ был успешным и данные правильные
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(100.0, response.getBody().get(0).getPrice());
        assertEquals(150.0, response.getBody().get(1).getPrice());
    }
}
