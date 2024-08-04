package co.com.erikdhv.events;

import co.com.erikdhv.model.events.EventDataDTO;
import co.com.erikdhv.model.events.EventSpect;
import co.com.erikdhv.model.events.gateways.EventType;
import co.com.erikdhv.model.events.gateways.EventsGateway;
import lombok.RequiredArgsConstructor;
import org.reactivecommons.api.domain.DomainEvent;
import org.reactivecommons.api.domain.DomainEventBus;
import org.reactivecommons.async.impl.config.annotations.EnableDomainEventBus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import reactor.core.publisher.Mono;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.logging.Level;

import static reactor.core.publisher.Mono.from;

@RequiredArgsConstructor
@EnableDomainEventBus
public class ReactiveEventsGateway implements EventsGateway {
    private final DomainEventBus domainEventBus;

    private static final Logger LOGGER = LoggerFactory.getLogger(ReactiveEventsGateway.class);
    private static final String DATE_FORMATED = "yyyy-MM-dd'T'hh:mm:ss";
    private static final String CONTENT_TYPE = "application/json";

    /*@Override
    public Mono<Void> emit(Object event) {
        log.log(Level.INFO, "Sending domain event: {0}: {1}", new String[]{SOME_EVENT_NAME, event.toString()});
         return from(domainEventBus.emit(new DomainEvent<>(SOME_EVENT_NAME, UUID.randomUUID().toString(), event)));
    }*/

    public Mono<Void> emit(DomainEvent<?> domainEvent) {
        return Mono.from(
                domainEventBus.emit( domainEvent )
        );
    }

    @Override
    public <T> Mono<Void> emitDone(T requestInfo, T responseInfo, EventType eventType) {
        return Mono.just(buildEventData(requestInfo, responseInfo, eventType))
                .flatMap(eventDataDTO -> getSpectEvent(eventType.getName(), eventDataDTO ))
                .doOnSuccess(this::getLog)
                .flatMap(this::emit);
    }

    @Override
    public <T> Mono<Void> emitReject(T requestInfo, Throwable exception, EventType eventType) {
        return Mono.error(exception)
                .onErrorResume();
    }

    private EventDataDTO<Object, Object> buildEventData(Object request, Object response, EventType eventType){
        return EventDataDTO.builder()
                .request(request)
                .response(response)
                .eventType(eventType)
                .build();
    }

    private Mono<DomainEvent<?>> getSpectEvent(String eventName, EventDataDTO<?, ?> eventDataDto){
        return Mono.just(EventSpect.builder()
                .type(eventName)
                .component("")
                .id(UUID.randomUUID().toString())
                .time(DateTimeFormatter.ofPattern(DATE_FORMATED).format(LocalDateTime.now()))
                .contentType(CONTENT_TYPE)
                .data(eventDataDto)
                .build()
            ).map(eventSpect -> new DomainEvent<>(eventName, eventSpect.getId(), eventSpect));
    }

    private void getLog(DomainEvent<?> domainEvent){
        LOGGER.info(
                MessageFormat.format("Sending domain event: {0}: {1}",
                        domainEvent.getName(), domainEvent.getEventId())
        );
    }
}
