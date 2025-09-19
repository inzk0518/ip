package faith.model.task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task {

    protected String by;

    private LocalDateTime byDateTime;

    private boolean hasTime;

    private static final DateTimeFormatter DMYHHMM = DateTimeFormatter.ofPattern("d/M/uuuu HHmm");
    private static final DateTimeFormatter DMYHHMM_ = DateTimeFormatter.ofPattern("d-M-uuuu HHmm");
    private static final DateTimeFormatter DMY = DateTimeFormatter.ofPattern("d/M/uuuu");
    private static final DateTimeFormatter DMY_ = DateTimeFormatter.ofPattern("d-M-uuuu");
    private static final DateTimeFormatter YMD = DateTimeFormatter.ofPattern("uuuu/M/d");
    private static final DateTimeFormatter ISO_DATE = DateTimeFormatter.ISO_LOCAL_DATE;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
        try {
            byDateTime = LocalDateTime.parse(by, DMYHHMM);
            hasTime = true;
        } catch (DateTimeParseException e) {}

        if (byDateTime == null) {
            try {
                byDateTime = LocalDateTime.parse(by, DMYHHMM_);
                hasTime = true;
            } catch (DateTimeParseException e) {}
        }

        if (byDateTime == null) {
            try { byDateTime = LocalDate.parse(by, DMY).atStartOfDay(); } catch (DateTimeParseException ignore) {}
        }
        if (byDateTime == null) {
            try { byDateTime = LocalDate.parse(by, DMY_).atStartOfDay(); } catch (DateTimeParseException ignore) {}
        }
        if (byDateTime == null) {
            try { byDateTime = LocalDate.parse(by, YMD).atStartOfDay(); } catch (DateTimeParseException ignore) {}
        }
        if (byDateTime == null) {
            try { byDateTime = LocalDate.parse(by, ISO_DATE).atStartOfDay(); } catch (DateTimeParseException ignore) {}
        }
    }

    @Override
    public String saveToFileFormat() {
        return "D | " + this.isDoneInt() + " | " + description + " | " + by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString()
                + " (by: " + (byDateTime == null ? this.by : (byDateTime.toLocalDate().format(DateTimeFormatter.ofPattern("MMM d uuuu"))
                 + (hasTime ? ", " + byDateTime.toLocalTime().format(DateTimeFormatter.ofPattern("h:mma")) : ""))) + ")";
    }
}