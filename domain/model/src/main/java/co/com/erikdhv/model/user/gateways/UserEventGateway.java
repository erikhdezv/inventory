package co.com.erikdhv.model.user.gateways;

import reactor.core.publisher.Mono;

public interface UserEventGateway {
    Mono<Void> registerSuccessfullUserDetailRecord(String name, Integer userId);
    Mono<Void> registerUnSuccessfullUserDetailRecord(String name, Integer userId, Throwable error);
}
