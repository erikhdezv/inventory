package co.com.erikdhv.usecase.role;

import co.com.erikdhv.model.role.Role;
import co.com.erikdhv.model.role.gateways.RoleEventGateway;
import co.com.erikdhv.model.role.gateways.RoleRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class RoleUseCase {
    private static final String ACTION = "GET";

    private final RoleRepository roleRepository;
    private final RoleEventGateway roleEventGateway;

    Flux<Role> getRol(Integer userId){
        return roleRepository.getRol(userId)
                .doOnError(throwable ->
                        roleEventGateway.registerUnSuccessfullRoleDetailRecord
                                (userId, ACTION, throwable).subscribe()
                )
                .doOnComplete(() ->
                        roleEventGateway.registerSuccessfullRoleDetailRecord(userId, ACTION).subscribe()
                );
    }

    /*Mono<Void> setRol(String name){

    }*/
}
