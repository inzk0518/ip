package faith.logic;

import faith.exception.FaithException;
import faith.logic.command.*;
import faith.model.TaskList;
import faith.model.task.Deadline;
import faith.model.task.Task;
import faith.model.task.Todo;

public class Parser {
    public static Command parse (String input) throws FaithException {
        String s = input.trim();
        if (s.equals("bye"))  return new ExitCommand();
        if (s.equals("list")) return new ListCommand();

        if (s.startsWith("mark ")) {
            int idx = parseIndex1Based(s.substring(5).trim());
            return new MarkCommand(idx);
        }
        if (s.startsWith("unmark ")) {
            int idx = parseIndex1Based(s.substring(7).trim());
            return new UnmarkCommand(idx);
        }
        if (s.startsWith("delete ")) {
            int idx = parseIndex1Based(s.substring(7).trim());
            return new DeleteCommand(idx);
        }
        if (s.startsWith("todo ")) {
            String desc = s.substring(5).trim();
            if (desc.isEmpty()) throw new FaithException("     The description of a todo cannot be empty.");
            return new AddTodoCommand(desc);
        }
        if (s.startsWith("deadline ")) {
            int i = s.indexOf(" /by ");
            if (i < 0) throw new FaithException("     Use: deadline <description> /by <date or date time>");
            String desc = s.substring(9, i).trim();
            String by = s.substring(i + 5).trim();
            if (desc.isEmpty() || by.isEmpty()) throw new FaithException("     Deadline needs both description and /by.");
            return new AddDeadlineCommand(desc, by);
        }
        if (s.startsWith("event ")) {
            int i = s.indexOf(" /from ");
            int j = s.indexOf(" /to ");
            if (i < 0) throw new FaithException("     Use: event <description> /from <date or date time> /to <date or date time>");
            String desc = s.substring(6, i).trim();
            String from = s.substring(i + 7).trim();
            String to = s.substring(j + 5).trim();
            if (desc.isEmpty() || from.isEmpty() || to.isEmpty()) throw new FaithException("     Deadline needs description, /from and /to.");
            return new AddEventCommand(desc, from, to);
        }

        throw new FaithException("     Sorry, I don't understand.");
    }

    private static int parseIndex1Based(String token) throws FaithException {
        try {
            int oneBased = Integer.parseInt(token);
            if (oneBased <= 0) throw new NumberFormatException();
            return oneBased;
        } catch (NumberFormatException e) {
            throw new FaithException("     Index must be a positive integer.");
        }
    }
}