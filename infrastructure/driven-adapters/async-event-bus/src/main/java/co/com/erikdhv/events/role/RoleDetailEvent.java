package co.com.erikdhv.events.role;

import co.com.erikdhv.model.role.gateways.RoleEventGateway;
import reactor.core.publisher.Mono;

public class RoleDetailEvent implements RoleEventGateway {
    @Override
    public Mono<Void> registerSuccessfullRoleDetailRecord(Integer userId, String action) {
        return null; /*Mono.just(userId).flatMap(response ->
                ReactiveDirectAsyncGateway. );*/
    }

    @Override
    public Mono<Void> registerUnSuccessfullRoleDetailRecord(Integer userId, String action, Throwable error) {
        return null;
    }
}
