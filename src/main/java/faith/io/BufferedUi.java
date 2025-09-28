package faith.io;

public class BufferedUi extends Ui {
    private final StringBuilder sb = new StringBuilder();

    /**
     * Prints a friendly greeting at program start.
     */
    @Override
    public void showWelcome() {
        sb.append("Hello! I'm Faith\nWhat can I do for you?\n");
    }

    /**
     * Prints a goodbye message just before the program exits.
     */
    @Override
    public void showGoodbye() {
        sb.append("Bye. Hope to see you again soon!\n");
    }

    /**
     * Prints a message.
     *
     * @param message text to print.
     */
    @Override
    public void show(String message) {
        sb.append(message).append('\n');
    }

    /**
     * Prints an error message .
     *
     * @param message description of the error.
     */
    @Override
    public void showError(String message) {
        sb.append(message).append('\n');
    }

    /**
     * Prints a specific message when loading stored tasks fails.
     */
    @Override
    public void showLoadingError() {
        sb.append("Oops, I couldn't load your tasks. Starting fresh.\n");
    }

    /** Returns accumulated text and clears the buffer. */
    public String drain() {
        String out = sb.toString().trim();
        sb.setLength(0);
        return out;
    }
}
