package it.edu.server.validators;

import it.edu.exceptions.ValidationException;

import java.util.Optional;

public class VoidValidation extends Validator {
    @Override
    public void check(Optional<String> email, Optional<String> password) throws ValidationException {
        checkNext(email, password);
    }
}
