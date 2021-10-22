package it.edu.server;

import it.edu.exceptions.LoginException;
import it.edu.exceptions.ValidationException;
import it.edu.server.validators.Validator;
import it.edu.server.validators.VoidValidation;

import java.util.HashMap;
import java.util.Optional;

public class Server {
    HashMap<String, String> registeredUsers;
    Validator loginInputChecks;
    Validator registerInputChecks;

    public Server() {
        this.registeredUsers = new HashMap<>();
        this.registerInputChecks = new VoidValidation();
        this.loginInputChecks = new VoidValidation();
    }

    public void register(String email, String password) {
        try {
            registerInputChecks.check(Optional.ofNullable(email), Optional.ofNullable(password));
            registeredUsers.put(email, password);
        } catch (ValidationException e) {
            System.out.println("Register Exception: " + e.getMessage());
        }
    }

    public void login(String email, String password) throws LoginException {
        try {
            loginInputChecks.check(Optional.ofNullable(email), Optional.ofNullable(password));
            if (registeredUsers.containsKey(email) && registeredUsers.get(email).equals(password)) {
                System.out.println("Login success!");
            } else {
                System.out.println("Invalid credentials!");
                throw new LoginException("Invalid credentials!");
            }
        } catch (ValidationException e) {
            System.out.println("Register Exception: " + e.getMessage());
            throw new LoginException(e.getMessage());
        }
    }

    public void setLoginInputChecks(Validator loginInputChecks) {
        this.loginInputChecks = loginInputChecks;
    }

    public void setRegisterInputChecks(Validator registerInputChecks) {
        this.registerInputChecks = registerInputChecks;
    }
}
