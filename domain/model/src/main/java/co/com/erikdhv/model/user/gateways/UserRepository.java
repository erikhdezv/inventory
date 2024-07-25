package co.com.erikdhv.model.user.gateways;

import co.com.erikdhv.model.user.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

public interface UserRepository {
    Flux<User> getUser();
    Mono<Void> setUser(String name, Integer age, Integer roleId, LocalDate admissionDate);
}
