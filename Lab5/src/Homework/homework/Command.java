package homework;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

interface Command {
    void execute() throws IOException, InvalidCommandArgumentException, DocumentAlreadyExistsException;
}
