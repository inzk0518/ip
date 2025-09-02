import java.util.Scanner;

public class Faith {
    public static void main(String[] args) {
        System.out.println("    ____________________________________________________________\n" +
                "    Hello! I'm Faith\n" +
                "    What can I do for you?\n" +
                "    ____________________________________________________________");
        Scanner scanner = new Scanner(System.in);
        Task[] taskList = new Task[100];
        int taskCount = 0;

        while(true) {
            String line = scanner.nextLine();
            System.out.println("    ____________________________________________________________");
            if (line.equals("bye")) {
                break;
            }
            if (line.equals("list")) {
                if (taskCount != 0) {
                    System.out.println("     Here are the tasks in your list: ");
                }
                for (int i = 0; i < taskCount; i++) {
                    System.out.println("     " + (i + 1) + "." + taskList[i]);
                }
                System.out.println("    ____________________________________________________________");
            } else {
                String[] parts = line.split(" ", 2);
                if (parts[0].equals("mark")) {
                    Task targetTask = taskList[Integer.parseInt(parts[1]) - 1];
                   targetTask.markDone();
                    System.out.println("     Nice! I've marked this task as done:");
                    System.out.println("       " + targetTask);
                    System.out.println("    ____________________________________________________________");
                } else if (parts[0].equals("unmark")) {
                    Task targetTask = taskList[Integer.parseInt(parts[1]) - 1];
                    targetTask.unmarkDone();
                    System.out.println("     OK, I've marked this task as not done yet:");
                    System.out.println("       " + targetTask);
                    System.out.println("    ____________________________________________________________");
                } else {
                    taskList[taskCount] = new Task(line);
                    taskCount++;
                    System.out.println("    added: " + line);
                    System.out.println("    ____________________________________________________________");
                }
            }
        }
        System.out.println("    Bye. Hope to see you again soon!");
        System.out.println("    ____________________________________________________________");
    }
}
