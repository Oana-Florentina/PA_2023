package homework;

import java.util.List;

class ListCommand extends GenericCommand {
    Catalog catalog;
    public ListCommand() {
        super("List");
    }

    @Override
    protected void doExecute() {
        List<Document> documents = catalog.getDocuments();
        for (Document document : documents) {
            System.out.println(document.getName());
        }
    }
}
