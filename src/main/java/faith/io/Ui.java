package faith.io;

import java.util.Scanner;

public class Ui {
    private final Scanner in = new Scanner(System.in);

    public void showWelcome() {
        System.out.println("    ____________________________________________________________\n" +
                "     Hello! I'm Faith\n" + "     What can I do for you?\n" +
                "    ____________________________________________________________");
    }

    public void showGoodbye() {
        System.out.println("     Bye. Hope to see you again soon!");
    }

    public void showLine() {
        System.out.println("    ____________________________________________________________");
    }

    public void show(String message) {
        System.out.println(message);
    }

    public void showError(String message) {
        System.out.println(message);
    }

    public void showLoadingError() {
        System.out.println("     OOPS!!! I couldn't load your tasks. Starting fresh.");
    }

    public String readCommand() {
        return in.nextLine();
    }
}
