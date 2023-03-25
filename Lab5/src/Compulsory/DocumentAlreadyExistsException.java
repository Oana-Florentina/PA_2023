package org.compulsory;

public class DocumentAlreadyExistsException extends Exception {
    public DocumentAlreadyExistsException(String message) {
        super(message);
    }
}