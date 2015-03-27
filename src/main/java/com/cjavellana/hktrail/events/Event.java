package com.cjavellana.hktrail.events;

import java.io.Serializable;

/**
 * This interface represents a system dispatchable event
 */
public interface Event {

    /**
     * Sets the event's parameter
     *
     * @param eventParameter
     */
    void setEventParameter(EventParameter eventParameter);

    /**
     * Returns the event's parameter
     *
     * @return
     */
    EventParameter getEventParameter();
}
