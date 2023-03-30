package homework;
/**
 * Exception thrown when attempting to add an invalid document to a catalog.
 */
class InvalidDocumentException extends Exception {
    public InvalidDocumentException(String message) {
        super(message);
    }
}