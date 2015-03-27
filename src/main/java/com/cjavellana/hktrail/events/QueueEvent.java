package com.cjavellana.hktrail.events;

/**
 * Created by cjavellana on 26/3/15.
 */
public enum QueueEvent implements Event {
    CREATE_QUEUE,
    ENQUEUE,
    DEQUEUE,
    DELETE_QUEUE,
    PRINT_QUEUE;

    private EventParameter eventParameter;

    @Override
    public void setEventParameter(EventParameter eventParameter) {
        this.eventParameter = eventParameter;
    }

    @Override
    public EventParameter getEventParameter() {
        return this.eventParameter;
    }

}
