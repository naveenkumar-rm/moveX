package com.naveenkumarrm.moveX.feature.signup;

import com.naveenkumarrm.moveX.data.dto.DriverDTO;
import com.naveenkumarrm.moveX.data.dto.EmployeeDTO;
import com.naveenkumarrm.moveX.data.dto.LoaderDTO;
import com.naveenkumarrm.moveX.data.repository.MoveXDB;

public class SignUpModel {
    private final SignUpView signUpView;

    public SignUpModel(SignUpView signUpView) {
        this.signUpView = signUpView;
    }

    public void registerEmployee(String name, String email, String password, String mobileNo) {
        EmployeeDTO employee = new EmployeeDTO();
        employee.setId(MoveXDB.getInstance().getNextEmployeeId());
        employee.setName(name);
        employee.setEmail(email);
        employee.setPassword(password);
        employee.setMobileNo(mobileNo);
        employee.setRole("EMPLOYEE");
        employee.setStatus("ACTIVE");
        employee.setCreatedAt(System.currentTimeMillis());

        MoveXDB.getInstance().addEmployee(employee);
        signUpView.onSuccess("Employee account created successfully!");
    }

    public void registerDriver(String name, String email, String password, String mobileNo, String licenseNumber) {
        DriverDTO driver = new DriverDTO();
        driver.setId(MoveXDB.getInstance().getNextDriverId());
        driver.setName(name);
        driver.setEmail(email);
        driver.setPassword(password);
        driver.setMobileNo(mobileNo);
        driver.setLicenseNumber(licenseNumber);
        driver.setStatus("ACTIVE");
        driver.setCreatedAt(System.currentTimeMillis());

        MoveXDB.getInstance().addDriver(driver);
        signUpView.onSuccess("Driver account created successfully!");
    }

    public void registerLoader(String name, String email, String password, String mobileNo) {
        LoaderDTO loader = new LoaderDTO();
        loader.setId(MoveXDB.getInstance().getNextLoaderId());
        loader.setName(name);
        loader.setEmail(email);
        loader.setPassword(password);
        loader.setMobileNo(mobileNo);
        loader.setStatus("ACTIVE");
        loader.setCreatedAt(System.currentTimeMillis());

        MoveXDB.getInstance().addLoader(loader);
        signUpView.onSuccess("Loader account created successfully!");
    }
}
