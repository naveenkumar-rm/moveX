package com.naveenkumarrm.moveX.data.repository;

import com.naveenkumarrm.moveX.data.dto.DriverDTO;
import com.naveenkumarrm.moveX.data.dto.EmployeeDTO;
import com.naveenkumarrm.moveX.data.dto.LoaderDTO;
import com.naveenkumarrm.moveX.data.dto.ShipmentDTO;
import com.naveenkumarrm.moveX.util.SessionManager;

import java.util.LinkedHashMap;
import java.util.Map;

public class MoveXDB {
    private static MoveXDB instance = null;

    private final Map<Long, EmployeeDTO> employees = new LinkedHashMap<>();
    private final Map<Long, DriverDTO> drivers = new LinkedHashMap<>();
    private final Map<Long, LoaderDTO> loaders = new LinkedHashMap<>();
    private final Map<Long, ShipmentDTO> shipments = new LinkedHashMap<>();

    private long nextEmployeeId = 1;
    private long nextDriverId = 1;
    private long nextLoaderId = 1;
    private long nextShipmentId = 1;

    private MoveXDB() {
    }

    public static MoveXDB getInstance() {
        if (instance == null) {
            instance = new MoveXDB();
        }
        return instance;
    }

    public long getNextEmployeeId() {
        return nextEmployeeId++;
    }

    public void addEmployee(EmployeeDTO employee) {
        employees.put(employee.getId(), employee);
    }

    public Map<Long, EmployeeDTO> getEmployees() {
        return employees;
    }

    public EmployeeDTO getEmployee(long id) {
        return employees.get(id);
    }

    public long getNextDriverId() {
        return nextDriverId++;
    }

    public void addDriver(DriverDTO driver) {
        drivers.put(driver.getId(), driver);
    }

    public Map<Long, DriverDTO> getDrivers() {
        return drivers;
    }

    public DriverDTO getDriver(long id) {
        return drivers.get(id);
    }

    public long getNextLoaderId() {
        return nextLoaderId++;
    }

    public void addLoader(LoaderDTO loader) {
        loaders.put(loader.getId(), loader);
    }

    public Map<Long, LoaderDTO> getLoaders() {
        return loaders;
    }

    public LoaderDTO getLoader(long id) {
        return loaders.get(id);
    }

    public long getNextShipmentId() {
        return nextShipmentId++;
    }

    public void addShipment(ShipmentDTO shipment) {
        shipments.put(shipment.getId(), shipment);
    }

    public Map<Long, ShipmentDTO> getShipments() {
        return shipments;
    }

    public ShipmentDTO getShipment(long id) {
        return shipments.get(id);
    }

    public boolean authenticate(String email, String password) {
        for (EmployeeDTO emp : employees.values()) {
            if (emp.getEmail().equals(email) && emp.getPassword().equals(password)) {
                SessionManager.getInstance().login("EMPLOYEE", emp.getId(), emp.getName());
                return true;
            }
        }
        for (DriverDTO driver : drivers.values()) {
            if (driver.getEmail().equals(email) && driver.getPassword().equals(password)) {
                SessionManager.getInstance().login("DRIVER", driver.getId(), driver.getName());
                return true;
            }
        }
        for (LoaderDTO loader : loaders.values()) {
            if (loader.getEmail().equals(email) && loader.getPassword().equals(password)) {
                SessionManager.getInstance().login("LOADER", loader.getId(), loader.getName());
                return true;
            }
        }
        return false;
    }
}
