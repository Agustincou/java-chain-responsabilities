package it.edu;

import it.edu.server.Server;
import it.edu.server.validators.EmailValidation;
import it.edu.server.validators.TooShortPasswordValidation;
import it.edu.server.validators.TooWeakPasswordValidation;
import it.edu.server.validators.Validator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Server server = new Server();

        Validator registerValidations = new EmailValidation();
        registerValidations.
                linkWith(new TooShortPasswordValidation(4)).
                linkWith(new TooWeakPasswordValidation());

        Validator loginValidations = new EmailValidation();

        server.setLoginInputChecks(loginValidations);
        server.setRegisterInputChecks(registerValidations);

        do {
            String inputString = requestUserAction();
            String userEmail;
            String userPassword;

            switch (inputString) {
                case "LOGIN":
                    userEmail = requestUserEmail();
                    userPassword = requestUserPassword();
                    server.login(userEmail, userPassword);
                    return;
                case "REGISTER":
                    userEmail = requestUserEmail();
                    userPassword = requestUserPassword();
                    server.register(userEmail, userPassword);
            }
        } while (true);
    }

    private static String requestUserAction() {
        System.out.println("Ingrese LOGIN si desea loguearse o ingrese REGISTER si desea registrarse");
        return new Scanner(System.in).nextLine();
    }

    private static String requestUserEmail() {
        System.out.println("Ingrese su email");
        return new Scanner(System.in).nextLine();
    }

    private static String requestUserPassword() {
        System.out.println("Ingrese su contraseña");
        return new Scanner(System.in).nextLine();
    }
}
