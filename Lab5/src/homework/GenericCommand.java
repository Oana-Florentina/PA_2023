package homework;
import java.io.IOException;
/**

 The GenericCommand abstract class provides a basic implementation of the Command interface
 by defining a name and an execute method that calls an abstract doExecute method.
 */
abstract class GenericCommand implements Command {
    private final String name;

    public GenericCommand(String name) {
        this.name = name;
    }
    /**
     * Executes the command by calling the doExecute method.
     * Prints a message to indicate the execution of the command.
     * @throws IOException if an I/O error occurs.
     */
    @Override
    public void execute() throws IOException {
        System.out.println("Executing " + name + " command...");
        doExecute();
    }
    /**
     * Performs the command's specific actions.
     * Must be implemented by concrete subclasses.
     * @throws IOException if an I/O error occurs.
     */
    protected abstract void doExecute() throws IOException;
}