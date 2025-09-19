package faith.model.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeadlineTest {

    @Test
    void constructor_parsesDateTime() {
        Deadline d = new Deadline("return book", "20/5/2025 1600");
        String out = d.toString();
        assertTrue(out.contains("May 20 2025"), "Pretty date missing");
        assertTrue(out.contains("4:00PM") || out.contains("4:00 PM"),
                "Pretty time missing: " + out);
    }

    @Test
    void constructor_parsesDateOnly() {
        Deadline d = new Deadline("return book", "20/5/2025");
        String out = d.toString();
        assertTrue(out.contains("May 20 2025"), "Pretty date missing");
        assertFalse(out.contains("AM") || out.contains("PM"),
                "Date-only should not include a time: " + out);
    }

    @Test
    void constructor_parsesIsoDate() {
        Deadline d = new Deadline("submit assignment", "2025-12-02");
        String out = d.toString();
        assertTrue(out.contains("Dec 2 2025") || out.contains("Dec 02 2025"),
                "Pretty ISO date missing: " + out);
    }
}
