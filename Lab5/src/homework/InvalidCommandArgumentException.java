package homework;
/**
 * An exception that is thrown when an invalid argument is passed to a command.
 */
public class InvalidCommandArgumentException extends Exception {
    public InvalidCommandArgumentException(String message) {
        super(message);
    }
}
