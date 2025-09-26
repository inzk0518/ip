package faith.io;

public class BufferedUi extends Ui {
    private final StringBuilder sb = new StringBuilder();

    @Override
    public void showWelcome() {
        sb.append("Hello! I'm Faith\nWhat can I do for you?\n");
    }

    @Override
    public void showGoodbye() {
        sb.append("Bye. Hope to see you again soon!\n");
    }

    @Override
    public void showLine() {} // no divider in GUI

    @Override
    public void show(String message) {
        sb.append(message).append('\n');
    }

    @Override
    public void showError(String message) {
        sb.append(message).append('\n');
    }

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
