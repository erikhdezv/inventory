package co.com.erikdhv.model.product.gateways;

import co.com.erikdhv.model.product.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface ProductRepository {
    Flux<Product> getProduct(String name, LocalDate admissionDate, Integer userId);
    Mono<Void> setProduct(String name, BigDecimal amount, LocalDate admissionDate, Integer userId);
    Mono<Void> editProduct(Long id);
    Mono<Void> deleteProduct(Long id, Integer userId);
}
