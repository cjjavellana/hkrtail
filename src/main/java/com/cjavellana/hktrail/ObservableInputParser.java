package com.cjavellana.hktrail;

import com.cjavellana.hktrail.events.DataTransferEvent;
import com.cjavellana.hktrail.events.Event;
import com.cjavellana.hktrail.events.EventParameter;

/**
 * <p>Parses the input command and dispatches an event to the registered event handler(s).</p>
 * <p/>
 * Example of stack commands are as follows:
 * <pre>
 *     {@code new_s i}      # Creates an empty stack at index i.
 *     {@code push i e}     # Adds element e to stack at index i.
 *     {@code pop i}        # Removes an element from the top of stack at index i
 *     {@code delete_s i}   # Deletes a stack at index i
 *     {@code print i}      # Prints the contents of the stack at index i
 * </pre>
 * Example of queue commands are as follows:
 * <pre>
 *      {@code new_q i}     # Creates a queue at index i
 *      {@code enqueue i e} # Adds element e at the end of the queue at index i
 *      {@code dequeue i}   # Removes an element from the front of the queue at index i
 *      {@code delete_q i}  # Deletes the queue at index i
 *      {@code print_q i}   # Prints the contents of the queue of i
 * </pre>
 * Example of element transfer commands between stacks & queues:
 * <pre>
 *  {@code stack->stack i j} # Transfers an element from the top of stack at index i to stack at index j
 *  {@code stack->queue i j} # Transfers an element from the top of stack at index i to the end of queue j
 * </pre>
 */
public class ObservableInputParser extends Observable {

    public void handleUserInput(String[] args) {
        if (args.length < 2 || args.length > 3) {
            printUsage();
            return;
        }
        try {
            if (args.length == 2) {
                String cmdStr = args[0];
                Commands cmd = Commands.valueOf(cmdStr.toUpperCase());

                EventParameter eventParameter = new EventParameter();
                eventParameter.setIndex(Integer.valueOf(args[1]));

                Event event = cmd.getEvent();
                event.setEventParameter(eventParameter);
                dispatchEvent(event);
            } else if (args.length == 3) {
                String cmdStr = args[0].replace("->", "_");
                Commands cmd = Commands.valueOf(cmdStr.toUpperCase());
                EventParameter eventParameter = new EventParameter();

                Event event = cmd.getEvent();
                if (event instanceof DataTransferEvent) {
                    eventParameter.setSrcIndex(Integer.valueOf(args[1]));
                    eventParameter.setDestIndex(Integer.valueOf(args[2]));
                } else {
                    eventParameter.setIndex(Integer.valueOf(args[1]));
                    eventParameter.setValue(Integer.valueOf(args[2]));
                }

                event.setEventParameter(eventParameter);
                dispatchEvent(event);
            }
        } catch (Exception e) {
            e.printStackTrace();
            printUsage();
        }

    }

    private void printUsage() {
        System.out.println("Usage: [command] [index] <value>");
        System.out.println();
        System.out.println("Stack Operations Commands:");
        System.out.println("new_s <i>      - Creates a stack at index i");
        System.out.println("push <i> <e>   - Push element e to the top of the stack at index i");
        System.out.println("pop <i>        - Removes an element at the top of the stack at index i");
        System.out.println("delete_s <i>   - Deletes a stack at index i");
        System.out.println("print_s <i>      - Prints the content of the stack at index i");
        System.out.println();
        System.out.println("Queue Operations Commands:");
        System.out.println("new_q <i>         - Creates a queue at index i");
        System.out.println("enqueue <i> <e>   - Push element e to the end of the queue at index i");
        System.out.println("dequeue <i>       - Removes an element from the head of the queue at index i");
        System.out.println("delete_q <i>      - Deletes a queue at index i");
        System.out.println("print_q <i>       - Prints the content of the queue at index i");
        System.out.println();
        System.out.println("Element Transfer Operations Commands:");
        System.out.println("stack->stack <i> <j>      - Transfers an element from the top of the stack at index i to ");
        System.out.println("                            the top of the stack at index j.");
        System.out.println("stack->queue <i> <j>      - Transfers an element from the top of the stack at index i to ");
        System.out.println("                            the end of the queue at index j.");
        System.out.println("queue->queue <i> <j>      - Transfers an element from the head of the queue at index i to ");
        System.out.println("                            the end of the queue at index j.");
        System.out.println("queue->stack <i> <j>      - Transfers an element from the head of the queue at index i to ");
        System.out.println("                            the top of the stack at index j.");
        System.out.println();
        System.out.println("Legend: ");
        System.out.println("<i> and <j> must be a positive integer from 0 to 9");
        System.out.println("<e> must be a positive integer from 0 to 1000");
    }
}
