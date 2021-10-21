package it.edu.server.validators;

import it.edu.exceptions.ValidationException;

import java.util.Optional;

public abstract class Validator {
    private Validator next;

    /**
     * Builds chains of Validator objects.
     */
    public Validator linkWith(Validator next) {
        this.next = next;
        return next;
    }

    /**
     * Subclasses will implement this method with concrete checks.
     */
    public abstract void check(Optional<String> email, Optional<String> password) throws ValidationException;

    /**
     * Runs check on the next object in chain or ends traversing if we're in
     * last object in chain.
     */
    protected void checkNext(Optional<String> email, Optional<String> password) throws ValidationException {
        if (next == null) {
            return;
        }
        next.check(email, password);
    }
}
