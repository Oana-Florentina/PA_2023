package homework;
/**

 Exception thrown when a document with the same ID as an already existing document is attempted to be added
 */
public class DocumentAlreadyExistsException extends Exception {
    public DocumentAlreadyExistsException(String message) {
        super(message);
    }
}