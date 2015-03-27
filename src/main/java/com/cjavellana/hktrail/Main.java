package com.cjavellana.hktrail;

import com.cjavellana.hktrail.eventhandlers.CommandHandler;

import java.util.Scanner;

/**
 * Created by cjavellana on 25/3/15.
 */
public class Main {

    public static void main(String... args) {
        System.out.println("========== Example 1 ==============");
        executeExample1();
        System.out.println("========== Example 2 ==============");
        executeExample2();
        System.out.println("========== Example 3 ==============");
        executeExample3();
        System.out.println("========== Example 4 ==============");
        executeExample4();
    }

    private static void executeExample1() {
        ObservableInputParser inputHandler = new ObservableInputParser();
        inputHandler.addObserver(new CommandHandler());

        String input1 = "new_s 0, push 0 96, new_s 5, print_s 5, push 5 28, push 5 99, push 5 88, pop 0, print_s 5, push 0 65, stack->stack 5 0, print_s 0";
        Scanner scanner1 = new Scanner(input1).useDelimiter(",");
        while (scanner1.hasNext()) {
            String[] command = scanner1.next().trim().split("\\s");
            inputHandler.handleUserInput(command);
        }
    }

    private static void executeExample2() {
        ObservableInputParser inputHandler = new ObservableInputParser();
        inputHandler.addObserver(new CommandHandler());
        String input2 = "new_s 0,push 0 96,new_s 5,print_s 5,push 5 28,push 5 99,push 5 33,push 5 88,pop 0,print_s 5,pop 0," +
                "push 0 65,push 5 99,push 5 13,push 5 99,push 5 1,push 5 99,push 5 0,push 5 9,push 5 87,stack->stack 5 0,print_s 0";
        Scanner scanner2 = new Scanner(input2).useDelimiter(",");
        while (scanner2.hasNext()) {
            String[] command = scanner2.next().trim().split("\\s");
            inputHandler.handleUserInput(command);
        }
    }

    private static void executeExample3() {
        String input = "new_s 0,push 0 96,new_s 5,print_s 5,push 5 28,push 5 99,new_q 0,push 5 33,push 5 88,pop 0, " +
                "print_s 5,pop 0,push 0 65,push 5 99,dequeue 0,enqueue 0 4,new_q 9,push 5 13,push 5 99,enqueue 0 43," +
                "enqueue 0 21,enqueue 0 17,enqueue 0 4,enqueue 9 0,enqueue 0 4,enqueue 0 43,enqueue 0 40,push 5 1," +
                "push 5 99,enqueue 0 33,enqueue 0 99,enqueue 0 8,push 5 0,push 5 9,delete_q 0,print_q 9,push 5 87,new_q 0," +
                "enqueue 0 19,print_q 0,stack->stack 5 0,print_s 0";
        ObservableInputParser inputHandler = new ObservableInputParser();
        inputHandler.addObserver(new CommandHandler());
        Scanner scanner = new Scanner(input).useDelimiter(",");
        while (scanner.hasNext()) {
            String[] command = scanner.next().trim().split("\\s");
            inputHandler.handleUserInput(command);
        }
    }

    private static void executeExample4() {
        String input = "new_s 0,push 0 96,new_s 5,print_s 5,push 5 28,push 5 99,new_q 0,push 5 33,push 5 88,pop 0," +
                "print_s 5,pop 0,push 0 65,push 5 99,dequeue 0,enqueue 0 4,new_q 9,push 5 13,push 5 99,enqueue 0 43," +
                "enqueue 0 21,enqueue 0 17,stack->queue 0 0,enqueue 0 4,stack->queue 0 0,enqueue 9 0,enqueue 0 4," +
                "enqueue 0 43,queue->queue 0 0,stack->stack 5 5,enqueue 0 40,push 5 1,push 5 99,enqueue 0 33,enqueue 0 99," +
                "enqueue 0 8,push 5 0,push 5 9,delete_q 0,print_q 9,push 5 87,new_q 0,stack->queue 5 0,enqueue 0 3," +
                "queue->queue 0 0,enqueue 0 19,stack->stack 5 0,print_s 0,print_s 5,print_q 0,print_q 9";
        ObservableInputParser inputHandler = new ObservableInputParser();
        inputHandler.addObserver(new CommandHandler());
        Scanner scanner = new Scanner(input).useDelimiter(",");
        while (scanner.hasNext()) {
            String[] command = scanner.next().trim().split("\\s");
            inputHandler.handleUserInput(command);
        }
    }
}
