package co.com.erikdhv.model.product.gateways;

import reactor.core.publisher.Mono;

public interface ProductEventGateway {
    Mono<Void> registerSuccessfullProductDetailRecord(String name, Integer userId);
    Mono<Void> registerUnSuccessfullProductDetailRecord(String name, Integer userId, Throwable error);
}
