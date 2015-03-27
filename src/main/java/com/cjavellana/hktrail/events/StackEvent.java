package com.cjavellana.hktrail.events;

/**
 * This class represents an operation event on the {@link java.util.Stack} such as: <br/>
 * <ul>
 * <li>CREATE_STACK</li>
 * <li>PUSH_ELEMENT</li>
 * <li>POP_ELEMENT</li>
 * <li>DELETE_STACK</li>
 * <li>PRINT_STACK</li>
 * </ul>
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
