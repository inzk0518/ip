package faith.logic;

import faith.exception.FaithException;
import faith.logic.command.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserParseTest {

    @Test
    void parse_list_returnsListCommand() throws FaithException {
        Command c = Parser.parse("list");
        assertTrue(c instanceof ListCommand);
    }

    @Test
    void parse_bye_returnsExitCommand() throws FaithException {
        Command c = Parser.parse("bye");
        assertTrue(c instanceof ExitCommand);
    }

    @Test
    void parse_todo_returnsAddTodoCommand() throws FaithException {
        Command c = Parser.parse("todo read book");
        assertTrue(c instanceof AddTodoCommand);
    }

    @Test
    void parse_deadline_valid_returnsAddDeadlineCommand() throws FaithException {
        Command c = Parser.parse("deadline return book /by 20/5/2025 1600");
        assertTrue(c instanceof AddDeadlineCommand);
    }

    @Test
    void parse_mark_returnsMarkCommand() throws FaithException {
        Command c = Parser.parse("mark 3");
        assertTrue(c instanceof MarkCommand);
    }

    @Test
    void parse_unmark_returnsUnmarkCommand() throws FaithException {
        Command c = Parser.parse("unmark 2");
        assertTrue(c instanceof UnmarkCommand);
    }

    @Test
    void parse_delete_returnsDeleteCommand() throws FaithException {
        Command c = Parser.parse("delete 5");
        assertTrue(c instanceof DeleteCommand);
    }

    @Test
    void parse_event_valid_returnsAddEventCommand() throws FaithException {
        Command c = Parser.parse("event project meeting /from 1/1/2025 0900 /to 1/1/2025 1000");
        assertTrue(c instanceof AddEventCommand);
    }

    @Test
    void parse_deadline_missingBy_throwsFaithException() {
        assertThrows(FaithException.class,
                () -> Parser.parse("deadline return book"),
                "Missing /by should throw FaithException");
    }

    @Test
    void parse_unknown_throwsFaithException() {
        assertThrows(FaithException.class,
                () -> Parser.parse("random shit"),
                "Unknown command should throw FaithException");
    }
}
