package com.naveenkumarrm.moveX.feature.driver;

import com.naveenkumarrm.moveX.data.dto.DriverDTO;
import com.naveenkumarrm.moveX.util.ConsoleInput;

public class DriverView {

    private final DriverModel driverModel;
    private final ConsoleInput consoleInput;

    public DriverView() {
        this.driverModel = new DriverModel(this);
        this.consoleInput = ConsoleInput.getInstance();
    }

    public void init() {
        System.out.println("---- Add Driver ----");
        String name = consoleInput.readText("Driver name: ");
        String email = consoleInput.readText("Driver email: ");
        String mobileNo = consoleInput.readText("Driver mobile: ");
        String licenseNumber = consoleInput.readText("License number: ");

        driverModel.createDriver(name, email, mobileNo, licenseNumber);
    }

    public void onDriverCreated(DriverDTO driver) {
        System.out.println("Driver created with id " + driver.getId());
    }
}
