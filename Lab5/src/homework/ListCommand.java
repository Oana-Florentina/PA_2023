package homework;

import java.util.List;
/**
 * Represents a command that lists all documents in a catalog.
 */
class ListCommand extends GenericCommand {
    Catalog catalog;
    public ListCommand() {
        super("List");
    }
    /**
     * Executes the List command by printing the names of all documents in the catalog.
     */
    @Override
    protected void doExecute() {
        List<Document> documents = catalog.getDocuments();
        for (Document document : documents) {
            System.out.println(document.getName());
        }
    }
}
