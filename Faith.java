import java.util.ArrayList;
import java.util.Scanner;

public class Faith {
    public static void main(String[] args) {
        System.out.println("    ____________________________________________________________\n" +
                "     Hello! I'm Faith\n" + "     What can I do for you?\n" +
                "    ____________________________________________________________");
        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> taskList = new ArrayList<>();

        while (true) {
            String line = scanner.nextLine().trim();
            System.out.println("    ____________________________________________________________");
            if (line.equals("bye")) {
                break;
            }
            if (line.equals("list")) {
                System.out.println("     Here are the tasks in your list:");
                for (int i = 0; i < taskList.size(); i++) {
                    System.out.println("     " + (i + 1) + "." + taskList.get(i));
                }
                System.out.println("    ____________________________________________________________");
            } else {
                try {
                    String[] parts = line.split(" ", 2);
                    if (parts[0].equals("todo")) {
                        //Todo
                        if (parts.length < 2) {
                            throw new IllegalArgumentException("     OOPS!!! The description of a todo cannot be empty.");
                        }
                        Task task = new Todo(parts[1]);
                        taskList.add(task);
                        System.out.println("     Got it. I've added this task:");
                        System.out.print("       ");
                        System.out.println(task.toString());
                        System.out.println("     Now you have " + taskList.size() + " tasks in the list.");
                    } else if (parts[0].equals("deadline")) {
                        //Deadline
                        if (parts.length < 2) {
                            throw new IllegalArgumentException("     OOPS!!! The description of a deadline cannot be empty.\n" +
                                    "Please do it like this : deadline <description> /by <date>");
                        }
                        String[] deadlineParts = parts[1].split("/by", 2);
                        if (deadlineParts.length != 2) {
                            throw new IllegalArgumentException("     OOPS!!! The deadline is missing.\n" +
                                    "Please do it like this : deadline <description> /by <date>");
                        }
                        Task task = new Deadline(deadlineParts[0].trim(), deadlineParts[1].trim());
                        taskList.add(task);
                        System.out.println("     Got it. I've added this task:");
                        System.out.print("       ");
                        System.out.println(task.toString());
                        System.out.println("     Now you have " + taskList.size() + " tasks in the list.");
                    } else if (parts[0].equals("event")) {
                        //Event
                        if (parts.length < 2) {
                            throw new IllegalArgumentException("     OOPS!!! The description of an event cannot be empty.");
                        }
                        String[] eventParts = parts[1].split("/from", 2);
                        if (eventParts.length != 2) {
                            throw new IllegalArgumentException("     OOPS!!! Invalid input. \n" +
                                    "Please do it like this : event <description> /from <time> to: <time>");
                        }
                        String[] timeParts = eventParts[1].split("/to", 2);
                        if (timeParts.length != 2) {
                            throw new IllegalArgumentException("     OOPS!!! Invalid input. \n" +
                                    "Please do it like this : event <description> /from <time> to: <time>");
                        }
                        Task task = new Event(eventParts[0].trim(), timeParts[0].trim(), timeParts[1].trim());
                        taskList.add(task);
                        System.out.println("     Got it. I've added this task:");
                        System.out.print("       ");
                        System.out.println(task.toString());
                        System.out.println("     Now you have " + taskList.size() + " tasks in the list.");
                    } else if (parts[0].equals("delete")) {
                        if (parts.length < 2) {
                            throw new IllegalArgumentException("     OOPS!!! Please specify the task number to delete.");
                        }
                        int deleteIndex;
                        try {
                            deleteIndex = Integer.parseInt(parts[1]) - 1;
                        } catch (NumberFormatException e) {
                            throw new IllegalArgumentException("     OOPS!!! Task number must be a valid integer.");
                        }
                        if  (deleteIndex < 0 || deleteIndex >= taskList.size()) {
                            throw new IllegalArgumentException("     OOPS!!! Invalid task number.");
                        }
                        System.out.println("     Noted. I've removed this task:");
                        System.out.println("       " + taskList.remove(deleteIndex).toString());
                        System.out.println("     Now you have " + taskList.size() + " tasks in the list.");
                    } else if (parts[0].equals("mark")) {
                        Task targetTask = taskList.get(Integer.parseInt(parts[1]) - 1);
                        targetTask.markDone();
                        System.out.println("     Nice! I've marked this task as done:");
                        System.out.println("       " + targetTask);
                    } else if (parts[0].equals("unmark")) {
                        Task targetTask = taskList.get(Integer.parseInt(parts[1]) - 1);
                        targetTask.unmarkDone();
                        System.out.println("     OK, I've marked this task as not done yet:");
                        System.out.println("       " + targetTask);
                    } else {
                        throw new IllegalArgumentException("     OOPS!!! I'm sorry, but I don't know what that means :-(");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("    ____________________________________________________________");
            }
        }
        System.out.println("     Bye. Hope to see you again soon!");
        System.out.println("    ____________________________________________________________");
    }
}
