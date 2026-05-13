package com.naveenkumarrm.moveX.util;

public class SessionManager {
    private static SessionManager instance;

    private String loggedInRole;
    private Long loggedInId;
    private String loggedInName;

    private SessionManager() {
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void login(String role, Long id, String name) {
        this.loggedInRole = role;
        this.loggedInId = id;
        this.loggedInName = name;
    }

    public void logout() {
        this.loggedInRole = null;
        this.loggedInId = null;
        this.loggedInName = null;
    }

    public boolean isLoggedIn() {
        return loggedInRole != null;
    }

    public String getLoggedInRole() {
        return loggedInRole;
    }

    public Long getLoggedInId() {
        return loggedInId;
    }

    public String getLoggedInName() {
        return loggedInName;
    }
}
