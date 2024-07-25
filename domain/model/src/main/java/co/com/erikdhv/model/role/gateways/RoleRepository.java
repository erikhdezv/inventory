package co.com.erikdhv.model.role.gateways;

import co.com.erikdhv.model.role.Role;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RoleRepository {
    Flux<Role> getRol(Integer userId);
    Mono<Void> setRol(String name);
}
