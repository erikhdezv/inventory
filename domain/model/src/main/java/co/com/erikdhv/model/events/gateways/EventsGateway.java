package co.com.erikdhv.model.events.gateways;

import reactor.core.publisher.Mono;

public interface EventsGateway {
    <T> Mono<Void> emitDone(T requestInfo, T responseInfo, EventType eventType);
    <T> Mono<Void> emitReject(T requestInfo, Throwable exception, EventType eventType);
}
