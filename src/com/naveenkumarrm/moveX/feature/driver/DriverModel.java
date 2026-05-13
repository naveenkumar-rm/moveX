package com.naveenkumarrm.moveX.feature.driver;

import com.naveenkumarrm.moveX.data.dto.DriverDTO;
import com.naveenkumarrm.moveX.data.repository.MoveXDB;

public class DriverModel {

    private final DriverView driverView;

    public DriverModel(DriverView driverView) {
        this.driverView = driverView;
    }

    public void createDriver(String name, String email, String mobileNo, String licenseNumber) {
        DriverDTO driver = new DriverDTO();
        driver.setId(MoveXDB.getInstance().getNextDriverId());
        driver.setName(name);
        driver.setEmail(email);
        driver.setMobileNo(mobileNo);
        driver.setLicenseNumber(licenseNumber);
        driver.setStatus("ACTIVE");
        driver.setCreatedAt(System.currentTimeMillis());

        MoveXDB.getInstance().addDriver(driver);
        driverView.onDriverCreated(driver);
    }
}
