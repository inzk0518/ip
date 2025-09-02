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
            String line = scanner.nextLine().trim();
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
                if (parts[0].equals("todo")) {
                    //Todo
                    Task task = new Todo(parts[1]);
                    taskList[taskCount++] = task;
                    System.out.println("     Got it. I've added this task: ");
                    System.out.print("       ");
                    System.out.println(task.toString());
                    System.out.println("     Now you have " + taskCount + " tasks in the list.");
                } else if (parts[0].equals("deadline")) {
                    //Deadline
                    String[] deadlineParts = parts[1].split("/by", 2);
                    Task task = new Deadline(deadlineParts[0].trim(), deadlineParts[1].trim());
                    taskList[taskCount++] = task;
                    System.out.println("     Got it. I've added this task: ");
                    System.out.print("       ");
                    System.out.println(task.toString());
                    System.out.println("     Now you have " + taskCount + " tasks in the list.");
                } else if (parts[0].equals("event")) {
                    //Event
                    String[] eventParts = parts[1].split("/from", 2);
                    String[] timeParts = eventParts[1].split("/to", 2);
                    Task task = new Event(eventParts[0].trim(), timeParts[0].trim(), timeParts[1].trim());
                    taskList[taskCount++] = task;
                    System.out.println("     Got it. I've added this task: ");
                    System.out.print("       ");
                    System.out.println(task.toString());
                    System.out.println("     Now you have " + taskCount + " tasks in the list.");
                } else if (parts[0].equals("mark")) {
                    Task targetTask = taskList[Integer.parseInt(parts[1]) - 1];
                   targetTask.markDone();
                    System.out.println("     Nice! I've marked this task as done:");
                    System.out.println("       " + targetTask);
                } else if (parts[0].equals("unmark")) {
                    Task targetTask = taskList[Integer.parseInt(parts[1]) - 1];
                    targetTask.unmarkDone();
                    System.out.println("     OK, I've marked this task as not done yet:");
                    System.out.println("       " + targetTask);
                } else {
                    taskList[taskCount] = new Task(line);
                    taskCount++;
                    System.out.println("    added: " + line);
                }
                System.out.println("    ____________________________________________________________");
            }
        }
        System.out.println("    Bye. Hope to see you again soon!");
        System.out.println("    ____________________________________________________________");
    }
}
