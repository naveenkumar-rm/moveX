package com.naveenkumarrm.moveX.data.dto;

public class Employee {
    private int id;
    private String employeeId;
    private String name;
    private String email;
    private String password;
    private String mobileNo;
    public enum role{
        Manager,
        Employee,
    };
    public enum status{
        Active,
        Inactive,
    };
    private long createdAt;

}
