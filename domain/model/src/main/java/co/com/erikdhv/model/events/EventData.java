package co.com.erikdhv.model.events;

import co.com.erikdhv.model.events.gateways.EventType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class EventData<T, K> {
    private T request;
    private T response;
    private EventType eventType;
}
