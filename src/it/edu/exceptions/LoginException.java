package it.edu.exceptions;

public class LoginException extends Exception {
    public LoginException(String errorMsg) {
        super(errorMsg);
    }
}
