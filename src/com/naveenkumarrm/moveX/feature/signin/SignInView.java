package com.naveenkumarrm.moveX.feature.signin;

import com.naveenkumarrm.moveX.util.ConsoleInput;

public class SignInView {
    private final SignInModel signInModel;
    private final ConsoleInput consoleInput;
    private boolean isLoginSuccessful = false;

    public SignInView() {
        this.signInModel = new SignInModel(this);
        this.consoleInput = ConsoleInput.getInstance();
    }

    public boolean init() {
        System.out.println("---- Sign In ----");
        String email = consoleInput.readText("Email: ");
        String password = consoleInput.readText("Password: ");
        signInModel.login(email, password);
        return isLoginSuccessful;
    }

    public void onSuccess() {
        isLoginSuccessful = true;
        System.out.println("Login successful!");
    }

    public void onError(String message) {
        isLoginSuccessful = false;
        System.out.println(message);
    }
}
