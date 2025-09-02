import java.util.Scanner;

public class Faith {
    public static void main(String[] args) {
        System.out.println("    ____________________________________________________________\n" +
                "    Hello! I'm Faith\n" +
                "    What can I do for you?\n" +
                "    ____________________________________________________________");
        Scanner scanner = new Scanner(System.in);
        String[] list = new String[100];
        int taskCount = 0;

        while(true) {
            String line = scanner.nextLine();
            System.out.println("    ____________________________________________________________");
            if (line.equals("bye")) {
                break;
            }
            if (line.equals("list")) {
                for (int i = 0; i < taskCount; i++) {
                    System.out.println("    " + (i + 1) + ". " + list[i]);
                }
                System.out.println("    ____________________________________________________________");
            } else {
                list[taskCount] = line;
                taskCount++;
                System.out.println("    added: " + line);
                System.out.println("    ____________________________________________________________");
            }
        }
        System.out.println("    Bye. Hope to see you again soon!");
        System.out.println("    ____________________________________________________________");
    }
}
