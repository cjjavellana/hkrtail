package com.cjavellana.hktrail.events;

/**
 * This class represents an operation event on the {@link java.util.Queue} such as: <br/>
 * <ul>
 * <li>CREATE_QUEUE</li>
 * <li>ENQUEUE</li>
 * <li>DEQUEUE</li>
 * <li>DELETE_QUEUE</li>
 * <li>PRINT_QUEUE</li>
 * </ul>
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
