package com.cjavellana.hktrail;

import com.cjavellana.hktrail.eventhandlers.CommandHandler;

/**
 * Created by cjavellana on 25/3/15.
 */
public class Main {

    public static void main(String... args) {
        ObservableInputParser inputHandler = new ObservableInputParser();
        inputHandler.addObserver(new CommandHandler());

//        inputHandler.handleUserInput(new String[]{"new_s", "1"});
//        inputHandler.handleUserInput(new String[]{"push", "1", "87"});
//        inputHandler.handleUserInput(new String[]{"push", "1", "9"});
//        inputHandler.handleUserInput(new String[]{"push", "1", "178"});
//        inputHandler.handleUserInput(new String[]{"print_s", "1"});
//        inputHandler.handleUserInput(new String[]{"print_s", "1"});
        String[][] cmdList = new String[][]{
                new String[]{"new_s", "0"},
                new String[]{"push", "0", "96"},
                new String[]{"new_s", "5"},
                new String[]{"print_s", "5"},
                new String[]{"push", "5", "28"},
                new String[]{"push", "5", "99"},
                new String[]{"new_q", "0"},
                new String[]{"push", "5", "33"},
                new String[]{"push", "5", "88"},
                new String[]{"pop", "0"},
                new String[]{"print_s", "5"},
                new String[]{"pop", "0"},
                new String[]{"push", "0", "65"},
                new String[]{"push", "5", "99"},
                new String[]{"dequeue", "0"},
                new String[]{"print_q", "0"}
        };
        for (String[] cmd : cmdList) {
            inputHandler.handleUserInput(cmd);
        }
    }
}
