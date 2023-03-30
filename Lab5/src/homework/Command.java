package homework;
import java.io.IOException;
/**
 * Interface for commands that can be executed by the application.
 */
interface Command {

    /**
     * Executes the command.
     *
     * @throws IOException if there is an I/O error.
     * @throws InvalidCommandArgumentException if the command argument is invalid.
     * @throws DocumentAlreadyExistsException if a document with the same ID already exists in the catalog.
     */
    void execute() throws Exception;
}
