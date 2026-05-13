package com.naveenkumarrm.moveX.feature.signin;

import com.naveenkumarrm.moveX.data.repository.MoveXDB;

public class SignInModel {
    private final SignInView signInView;

    public SignInModel(SignInView signInView) {
        this.signInView = signInView;
    }

    public void login(String email, String password) {
        if (MoveXDB.getInstance().authenticate(email, password)) {
            signInView.onSuccess();
        } else {
            signInView.onError("Invalid credentials. Please try again.");
        }
    }
}
