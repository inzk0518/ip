package faith.logic;

import faith.exception.FaithException;
import faith.logic.command.*;

/**
 * Parses user input strings into executable {@link Command} objects.
 * Responsible only for syntactic interpretation; execution happens in commands.
 */
public class Parser {

    /**
     * Parses the original user command into a specific {@link Command} instance.
     * <p>
     * Supported commands include: list, bye, todo, deadline, event, mark, unmark, delete.
     *
     * @param input the command line input from user.
     * @return a {@link Command} instance.
     * @throws FaithException if the command is unknown or arguments are invalid.
     */
    public static Command parse(String input) throws FaithException {
        assert input != null : "parse input must not be null";
        String s = input.trim();
        if (s.equals("bye")) return new ExitCommand();
        if (s.equals("list")) return new ListCommand();

        if (s.startsWith("mark ")) {
            int idx = Integer.parseInt(s.substring(5).trim());
            assert idx > 0 : "mark: index must be > 0";
            if (idx <= 0) {
                throw new FaithException("Index must be a positive integer.");
            }
            return new MarkCommand(idx);
        }
        if (s.startsWith("unmark ")) {
            int idx = Integer.parseInt(s.substring(7).trim());
            assert idx > 0 : "unmark: index must be > 0";
            if (idx <= 0) {
                throw new FaithException("Index must be a positive integer.");
            }
            return new UnmarkCommand(idx);
        }
        if (s.startsWith("delete ")) {
            int idx = Integer.parseInt(s.substring(7).trim());
            assert idx > 0 : "delete: index must be > 0";
            if (idx <= 0) {
                throw new FaithException("Index must be a positive integer.");
            }
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
            if (desc.isEmpty() || by.isEmpty())
                throw new FaithException("     Deadline needs both description and /by.");
            return new AddDeadlineCommand(desc, by);
        }
        if (s.startsWith("event ")) {
            int i = s.indexOf(" /from ");
            int j = s.indexOf(" /to ");
            if (i < 0)
                throw new FaithException("     Use: event <description> /from <date or date time> /to <date or date time>");
            String desc = s.substring(6, i).trim();
            String from = s.substring(i + 7).trim();
            String to = s.substring(j + 5).trim();
            if (desc.isEmpty() || from.isEmpty() || to.isEmpty())
                throw new FaithException("     Deadline needs description, /from and /to.");
            return new AddEventCommand(desc, from, to);
        }
        if (s.startsWith("find ")) {
            String keyword = s.substring(5).trim();
            if (keyword.isEmpty()) {
                throw new FaithException("     Find keywords cannot be empty.");
            }
            return new FindCommand(keyword);
        }
        throw new FaithException("     Sorry, I don't understand.");
    }
}
