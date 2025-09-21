package faith.io;

import java.util.Scanner;

/**
 * Handles all user interaction: reading commands and printing messages.
 * Keeps business logic out of I/O code.
 */
public class Ui {
    private final Scanner in = new Scanner(System.in);

    /**
     * Prints a friendly greeting at program start.
     */
    public void showWelcome() {
        System.out.println("    ____________________________________________________________\n" +
                "     Hello! I'm Faith\n" + "     What can I do for you?\n" +
                "    ____________________________________________________________");
    }

    /**
     * Prints a goodbye message just before the program exits.
     */
    public void showGoodbye() {
        System.out.println("     Bye. Hope to see you again soon!");
    }

    /**
     * Prints a horizontal divider line for visual separation.
     */
    public void showLine() {
        System.out.println("    ____________________________________________________________");
    }

    /**
     * Prints a message.
     *
     * @param message text to print.
     */
    public void show(String message) {
        System.out.println(message);
    }

    /**
     * Prints an error message .
     *
     * @param message description of the error.
     */
    public void showError(String message) {
        System.out.println(message);
    }

    /**
     * Prints a specific message when loading stored tasks fails.
     */
    public void showLoadingError() {
        System.out.println("     OOPS!!! I couldn't load your tasks. Starting fresh.");
    }

    /**
     * Reads a full line of single command fron user input.
     *
     * @return the original command line.
     */
    public String readCommand() {
        return in.nextLine();
    }
}
