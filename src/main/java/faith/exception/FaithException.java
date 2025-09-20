package faith.exception;

/**
 * checked exception for recoverable errors
 * (e.g., unscripted commands, I/O failures).
 */
public class FaithException extends Exception {

    /**
     * Constructs a new {@code FaithException} with a human-readable message.
     *
     * @param msg reason for the failure.
     */
    public FaithException(String msg) {
        super(msg);
    }

    /**
     * Constructs a new {@code FaithException}.
     */
    public FaithException() {
        super();
    }
}