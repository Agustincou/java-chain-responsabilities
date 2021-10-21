package it.edu.exceptions;

public class ValidationException extends Exception {
    public ValidationException(String errorMsg) {
        super(errorMsg);
    }
}
