package it.edu.server.validators;

import it.edu.exceptions.ValidationException;

import java.util.Optional;

public class TooShortPasswordValidation extends Validator {
    int minimumLength = 0;

    public TooShortPasswordValidation(int minimumLength) {
        this.minimumLength = minimumLength;
    }

    @Override
    public void check(Optional<String> email, Optional<String> password) throws ValidationException {
        if (!password.isPresent() || password.get().length() < minimumLength) {
            throw new ValidationException("Password too short. Minimum required length: " + minimumLength);
        }
        checkNext(email, password);
    }
}
