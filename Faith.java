import java.util.Scanner;

public class Faith {
    public static void main(String[] args) {
        System.out.println("    ____________________________________________________________\n" +
                "    Hello! I'm Faith\n" +
                "    What can I do for you?\n" +
                "    ____________________________________________________________");
        Scanner scanner = new Scanner(System.in);

        while(true) {
            String line = scanner.nextLine();
            System.out.println("    ____________________________________________________________");
            if(line.equals("bye")) {
                break;
            }
            System.out.println("    " + line);
            System.out.println("    ____________________________________________________________");
        }
        System.out.println("    Bye. Hope to see you again soon!");
        System.out.println("    ____________________________________________________________");
    }
}
