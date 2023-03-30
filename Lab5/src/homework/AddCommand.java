package homework;
/**

 This class represents the command to add a document to a catalog.
 */
public class AddCommand implements Command {
    private Catalog catalog;
    private Document document;

    /**

     Constructor for the AddCommand class.
     Initializes the catalog and document.
     @param catalog the catalog where a document will be added
     @param document the document to be added
     */
    public AddCommand(Catalog catalog, Document document) {
        this.catalog = catalog;
        this.document = document;
    }

    /**

     Adds the document to the current catalog.
     @throws DocumentAlreadyExistsException if the document already exists in the catalog
     */
    @Override
    public void execute() throws DocumentAlreadyExistsException {
        catalog.addDocument(document);
        System.out.println("New document added!");
    }
}