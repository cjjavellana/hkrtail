package com.cjavellana.hktrail.eventhandlers;

import com.cjavellana.hktrail.events.DataTransferEvent;
import com.cjavellana.hktrail.events.EventParameter;
import com.cjavellana.hktrail.events.QueueEvent;
import com.cjavellana.hktrail.events.StackEvent;

import java.util.*;

/**
 * This class is designed to be used as an {@link java.util.Observer} to an {@link java.util.Observable} object.
 */
public class CommandHandler implements Observer {
    private static final int MAX_ELEMENTS = 10;

    private Stack[] stacks = new Stack[10];
    private Deque[] queues = new Deque[10];

    private int stacksCount = 0;
    private int queuesCount = 0;

    @Override
    public void update(Observable o, Object arg) {
        if (arg != null && arg instanceof StackEvent) {
            handleStackEvents((StackEvent) arg);
        } else if (arg != null && arg instanceof QueueEvent) {
            handleQueueEvents((QueueEvent) arg);
        } else if (arg != null && arg instanceof DataTransferEvent) {
            handleDataTransferEvent((DataTransferEvent) arg);
        }
    }

    protected void handleStackEvents(StackEvent stackEvent) {
        EventParameter eventParameter = stackEvent.getEventParameter();

        switch (stackEvent) {
            case CREATE_STACK:
                createStackAt(eventParameter.getIndex());
                break;
            case PUSH_ELEMENT:
                push(eventParameter.getIndex(), eventParameter.getValue());
                break;
            case POP_ELEMENT:
                pop(eventParameter.getIndex());
                break;
            case DELETE_STACK:
                destroyStack(eventParameter.getIndex());
                break;
            case PRINT_STACK:
                printStack(eventParameter.getIndex());
                break;
            default:
                System.out.println("error: unknown command");
        }
    }

    protected void handleQueueEvents(QueueEvent queueEvent) {
        EventParameter eventParameter = queueEvent.getEventParameter();

        switch (queueEvent) {
            case CREATE_QUEUE:
                createQueue(eventParameter.getIndex());
                break;
            case ENQUEUE:
                enqueue(eventParameter.getIndex(), eventParameter.getValue());
                break;
            case DEQUEUE:
                dequeue(eventParameter.getIndex());
                break;
            case DELETE_QUEUE:
                destroyQueue(eventParameter.getIndex());
                break;
            case PRINT_QUEUE:
                printQueue(eventParameter.getIndex());
                break;
            default:
                System.out.println("error: unknown command");
        }
    }

    protected void handleDataTransferEvent(DataTransferEvent transferEvent) {
        EventParameter eventParameter = transferEvent.getEventParameter();

        switch (transferEvent) {
            case STACK_STACK:
                transferFromStackToStack(eventParameter.getSrcIndex(), eventParameter.getDestIndex());
                break;
            case STACK_QUEUE:
                transferFromStackToQueue(eventParameter.getSrcIndex(), eventParameter.getDestIndex());
                break;
            case QUEUE_QUEUE:
                transferFromQueueToQueue(eventParameter.getSrcIndex(), eventParameter.getDestIndex());
                break;
            case QUEUE_STACK:
                transferFromQueueToStack(eventParameter.getSrcIndex(), eventParameter.getDestIndex());
                break;
            default:
                System.out.println("error: unknown command");
        }
    }

    /**
     * Creates a stack at the specified index
     *
     * @param index
     */
    protected void createStackAt(int index) {
        if (stacks[index] != null) {
            System.out.println("Index is not empty at " + index);
            return;
        }

        if (stacksCount < 9) {
            stacks[index] = new Stack();
            stacksCount++;
        } else {
            System.out.println("error: stack is full");
            return;
        }

    }

    /**
     * Puts the {@code value} at the top of the stack at {@code stackIndex}
     *
     * @param stackIndex
     * @param value
     */
    protected void push(int stackIndex, int value) {
        Stack stack = stacks[stackIndex];
        //check if a stack exists at stackIndex
        if (stack == null) {
            System.out.println("Index is not empty at " + stackIndex);
            return;
        }

        if (value < 0 || value > 1000) {
            System.out.println("error: Value must be between 0 and 1000");
            return;
        }

        if (stack.size() < MAX_ELEMENTS) {
            stack.push(value);
        } else {
            System.out.println("error: stack is full");
        }
    }

    /**
     * Removes an element from the top of the stack {@code stackIndex} and returns it
     *
     * @param stackIndex
     *
     * @return The value at the top of the stack at {@code stackIndex} or -1 if an error occurred
     */
    protected Integer pop(int stackIndex) {
        Stack stack = stacks[stackIndex];
        //check if a stack exists at stackIndex
        if (stack == null) {
            System.out.println("error: No stack exists at " + stackIndex);
            return -1;
        }

        if (stack.isEmpty()) {
            System.out.println("error: stack is empty");
            return -1;
        }

        Integer val = (Integer) stack.pop();
        return val;
    }

    /**
     * Prints the content of the stack at {@code stackIndex}
     *
     * @param stackIndex
     */
    protected void printStack(int stackIndex) {
        Stack stack = stacks[stackIndex];

        //check if a stack exists at stackIndex
        if (stack == null) {
            System.out.println("error: no stack exists at " + stackIndex);
            return;
        }

        if (stack.isEmpty()) {
            System.out.println("empty");
        } else {
            for (Iterator<Integer> iterator = stack.iterator(); iterator.hasNext(); ) {
                System.out.print(iterator.next() + " ");
            }
            System.out.println();
        }
    }

    /**
     * Destroys the stack at {@code stackIndex}
     *
     * @param stackIndex
     */
    protected void destroyStack(int stackIndex) {
        //check if a stack exists at stackIndex
        if (stacks[stackIndex] == null) {
            System.out.println("error: no stack exists at " + stackIndex);
            return;
        }

        stacks[stackIndex] = null;
        stacksCount--;
    }

    /**
     * Creates a {@link java.util.Queue} at the specified index
     *
     * @param index
     */
    protected void createQueue(int index) {
        if (queues[index] != null) {
            System.out.println("error: queue not empty at index " + index);
            return;
        }

        if (queuesCount < 9) {
            queues[index] = new ArrayDeque(MAX_ELEMENTS);
            queuesCount++;
        } else {
            System.out.println("error: stack is full");
            return;
        }
    }

    /**
     * Inserts {@code value} at the end of the queue at index {@code index}
     *
     * @param index
     *         The queue index
     * @param value
     *         The value
     */
    protected void enqueue(int index, int value) {
        Queue queue = queues[index];

        if (queue == null) {
            System.out.println("error: no queue exists at " + queues);
            return;
        }

        if (value < 0 || value > 1000) {
            System.out.println("error: Value must be between 0 and 1000");
            return;
        }

        if (queue.size() < 10) {
            queue.add(value);
        } else {
            System.out.println("error: queue is full");
        }
    }

    /**
     * Removes an element at the head of the queue
     *
     * @param index
     */
    protected void dequeue(int index) {
        Queue queue = queues[index];

        if (queue == null) {
            System.out.println("error: no queue exists at " + queues);
            return;
        }

        if (queue.isEmpty()) {
            System.out.println("error: queue is empty");
        } else {
            queue.remove();
        }
    }

    /**
     * Destroys the queue at the specified index
     *
     * @param index
     */
    protected void destroyQueue(int index) {
        Queue queue = queues[index];

        if (queue == null) {
            System.out.println("error: no queue exists at " + queues);
            return;
        }

        queues[index] = null;
        queuesCount--;
    }

    /**
     * Prints the content of the queue at the specified index
     *
     * @param index
     */
    protected void printQueue(int index) {
        Queue queue = queues[index];

        if (queue == null) {
            System.out.println("error: no queue exists at " + queues);
            return;
        }

        if (queue.isEmpty()) {
            System.out.println("empty");
        } else {
            for (Iterator iterator = ((Deque) queue).descendingIterator(); iterator.hasNext(); ) {
                System.out.print(iterator.next() + " ");
            }
            System.out.println();
        }
    }

    /**
     * Transfers an element from the top of the stack at {@code srcIndex} to the stack at {@code destIndex}
     *
     * @param srcIndex
     *         The source stack index
     * @param destIndex
     *         The destination stack index
     */
    protected void transferFromStackToStack(int srcIndex, int destIndex) {
        Stack srcStack = stacks[srcIndex];
        Stack destStack = stacks[destIndex];

        if (srcStack == null || destStack == null) {
            System.out.println("error: either the source stack or destination stack does not exist");
            return;
        }

        if (srcStack.isEmpty() || destStack.size() == 10) {
            System.out.println("error: wrong command");
            return;
        }

        destStack.push(srcStack.pop());
    }

    /**
     * Transfers an element from the top of the source stack at {@code srcIndex} to the end of the destination queue at
     * {@code destIndex}
     *
     * @param srcIndex
     * @param destIndex
     */
    protected void transferFromStackToQueue(int srcIndex, int destIndex) {
        Stack srcStack = stacks[srcIndex];
        Queue destQueue = queues[destIndex];

        if (srcStack == null || destQueue == null) {
            System.out.println("error: either the source stack or destination queue does not exist");
            return;
        }

        if (srcStack.isEmpty() || destQueue.size() == 10) {
            System.out.println("error: wrong command");
            return;
        }

        destQueue.add(srcStack.pop());
    }

    /**
     * Transfers an element from the head of the source queue at {@code srcIndex} to the tail of the destination queue
     * at {@code destIndex}
     *
     * @param srcIndex
     * @param destIndex
     */
    protected void transferFromQueueToQueue(int srcIndex, int destIndex) {
        Queue srcQueue = queues[srcIndex];
        Queue destQueue = queues[destIndex];

        if (srcQueue == null || destQueue == null) {
            System.out.println("error: either the source queue or destination queue does not exist");
            return;
        }

        if (srcQueue.isEmpty() || destQueue.size() == 10) {
            System.out.println("error: wrong command");
            return;
        }

        destQueue.add(srcQueue.remove());
    }

    /**
     * Transfers an element from the source queue at {@code srcIndex} to the destination stack at {@code destIndex}
     *
     * @param srcIndex
     * @param destIndex
     */
    protected void transferFromQueueToStack(int srcIndex, int destIndex) {
        Queue srcQueue = queues[srcIndex];
        Stack destStack = stacks[destIndex];

        if (srcQueue == null || destStack == null) {
            System.out.println("error: either the source queue or destination stack does not exist");
            return;
        }

        if (srcQueue.isEmpty() || destStack.size() == 10) {
            System.out.println("error: wrong command");
            return;
        }

        destStack.push(srcQueue.remove());
    }
}
