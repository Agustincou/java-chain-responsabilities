package it.edu.server.validators;

import it.edu.exceptions.ValidationException;

import java.util.Optional;

public class TooWeakPasswordValidation extends Validator {
    @Override
    public void check(Optional<String> email, Optional<String> password) throws ValidationException {
        if (!password.isPresent() || password.get().contains("1234")) {
            throw new ValidationException("Too weak password. Be more creative!");
        }
        checkNext(email, password);
    }
}
