package faith.model.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Event with description, start and end time.
 */
public class Event extends Task {
    protected String fromTime;
    protected String toTime;

    /**
     * Create an Event instance with description, start time and end time.
     *
     * @param description the description of the event.
     * @param fromTime the time event start.
     * @param toTime the time event end.
     */
    public Event(String description, String fromTime, String toTime) {
        super(description);
        this.fromTime = fromTime;
        this.toTime = toTime;
    }

    /**
     * Change event start time.
     *
     * @param newFrom the new event start time.
     */
    public void setFrom(String newFrom) {
        this.fromTime = newFrom;
    }

    /**
     * Change event end time.
     *
     * @param newTo the new event end time.
     */
    public void setTo(String newTo) {
        this.toTime = newTo;
    }

    /**
     * Save the event in a format to be stored in a file
     *
     * @return the event in stored format
     */
    @Override
    public String saveToFileFormat() {
        return "T | " + this.isDoneInt() + " | " + description + " | " + fromTime + "-" + toTime;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + fromTime + " to: " + toTime + ")";
    }
}