package com.cjavellana.hktrail;

import com.cjavellana.hktrail.events.Event;

/**
 * Created by cjavellana on 25/3/15.
 */
public class Observable extends java.util.Observable {

    /**
     * Dispatches an event to notify any subscribing observers
     *
     * @param event
     *         The event to dispatch
     */
    protected void dispatchEvent(Event event) {
        setChanged();
        notifyObservers(event);
    }
}
