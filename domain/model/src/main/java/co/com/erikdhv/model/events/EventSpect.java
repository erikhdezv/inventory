package co.com.erikdhv.model.events;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EventSpect {
    protected String type;
    protected String component;
    protected String id;
    protected String time;
    protected String contentType;
    protected EventData<?, ?> data;
}
