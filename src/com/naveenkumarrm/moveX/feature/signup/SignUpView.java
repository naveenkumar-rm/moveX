package com.naveenkumarrm.moveX.feature.signup;

import com.naveenkumarrm.moveX.util.ConsoleInput;

public class SignUpView {
    private final SignUpModel signUpModel;
    private final ConsoleInput consoleInput;

    public SignUpView() {
        this.signUpModel = new SignUpModel(this);
        this.consoleInput = ConsoleInput.getInstance();
    }

    public void init() {
        System.out.println("---- Employee Sign Up ----");
        System.out.println("Only Employees can create accounts for Drivers and Loaders.");
        System.out.println("Enter details for a new Employee account.");

        String name = consoleInput.readText("Name: ");
        String email = consoleInput.readText("Email: ");
        String password = consoleInput.readText("Password: ");
        String mobileNo = consoleInput.readText("Mobile: ");

        signUpModel.registerEmployee(name, email, password, mobileNo);
    }

    public void onSuccess(String message) {
        System.out.println(message);
    }
}
