package com.cjavellana.hktrail;

import com.cjavellana.hktrail.events.DataTransferEvent;
import com.cjavellana.hktrail.events.Event;
import com.cjavellana.hktrail.events.QueueEvent;
import com.cjavellana.hktrail.events.StackEvent;

/**
 * Created by cjavellana on 26/3/15.
 */
public enum Commands {
    // Stack Commands
    NEW_S(StackEvent.CREATE_STACK),
    PUSH(StackEvent.PUSH_ELEMENT),
    POP(StackEvent.POP_ELEMENT),
    DELETE_S(StackEvent.DELETE_STACK),
    PRINT_S(StackEvent.PRINT_STACK),

    // Queue Commands
    NEW_Q(QueueEvent.CREATE_QUEUE),
    ENQUEUE(QueueEvent.ENQUEUE),
    DEQUEUE(QueueEvent.DEQUEUE),
    DELETE_Q(QueueEvent.DELETE_QUEUE),
    PRINT_Q(QueueEvent.PRINT_QUEUE),

    // Element Transfer Commands
    STACK_STACK(DataTransferEvent.STACK_STACK),
    STACK_QUEUE(DataTransferEvent.STACK_QUEUE),
    QUEUE_QUEUE(DataTransferEvent.QUEUE_QUEUE),
    QUEUE_STACK(DataTransferEvent.QUEUE_STACK);

    private Event event;

    private Commands(Event event) {
        this.event = event;
    }

    public Event getEvent() {
        return this.event;
    }
}
