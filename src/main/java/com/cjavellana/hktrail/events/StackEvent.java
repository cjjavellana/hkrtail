package com.cjavellana.hktrail.events;

/**
 * Created by cjavellana on 25/3/15.
 */
public enum StackEvent implements Event {

    CREATE_STACK,
    PUSH_ELEMENT,
    POP_ELEMENT,
    DELETE_STACK,
    PRINT_STACK;

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
