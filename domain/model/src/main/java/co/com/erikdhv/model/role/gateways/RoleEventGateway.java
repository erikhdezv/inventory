package co.com.erikdhv.model.role.gateways;

import reactor.core.publisher.Mono;

public interface RoleEventGateway {
    Mono<Void> registerSuccessfullRoleDetailRecord(Integer userId, String action);
    Mono<Void> registerUnSuccessfullRoleDetailRecord(Integer userId, String action, Throwable error);
}
