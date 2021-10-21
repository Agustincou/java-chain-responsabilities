package it.edu.server.validators;

import it.edu.exceptions.ValidationException;

import java.util.Optional;

public class EmailValidation extends Validator {
    @Override
    public void check(Optional<String> email, Optional<String> password) throws ValidationException {
        if (!email.isPresent() || !email.get().contains("@")) {
            throw new ValidationException("Invalid email format");
        }
        checkNext(email, password);
    }
}
