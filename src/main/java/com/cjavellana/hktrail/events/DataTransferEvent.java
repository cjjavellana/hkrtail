package com.cjavellana.hktrail.events;

/**
 * Created by cjavellana on 26/3/15.
 */
public enum DataTransferEvent implements Event {

    STACK_STACK,
    STACK_QUEUE,
    QUEUE_QUEUE,
    QUEUE_STACK;

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
