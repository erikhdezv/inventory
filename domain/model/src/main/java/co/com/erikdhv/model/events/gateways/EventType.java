package co.com.erikdhv.model.events.gateways;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EventType {
    ROLE_DONE (""),
    ROLE_REJECT (""),
    USER_DONE (""),
    USER_REJECT (""),
    PRODUCT_DONE (""),
    PRODUCT_REJECT ("");

    private final String name;
}
