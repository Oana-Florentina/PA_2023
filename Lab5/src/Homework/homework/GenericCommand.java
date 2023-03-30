package homework;

import java.io.IOException;

abstract class GenericCommand implements Command {
    private final String name;

    public GenericCommand(String name) {
        this.name = name;
    }

    @Override
    public void execute() throws IOException {
        System.out.println("Executing " + name + " command...");
        doExecute();
    }

    protected abstract void doExecute() throws IOException;
}