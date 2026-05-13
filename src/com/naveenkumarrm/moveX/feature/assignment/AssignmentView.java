package com.naveenkumarrm.moveX.feature.assignment;

import com.naveenkumarrm.moveX.data.dto.DriverDTO;
import com.naveenkumarrm.moveX.data.dto.LoaderDTO;
import com.naveenkumarrm.moveX.data.dto.ShipmentDTO;
import com.naveenkumarrm.moveX.util.ConsoleInput;

import java.util.List;

public class AssignmentView {

    private final AssignmentModel assignmentModel;
    private final ConsoleInput consoleInput;

    public AssignmentView() {
        this.assignmentModel = new AssignmentModel(this);
        this.consoleInput = ConsoleInput.getInstance();
    }

    public void init() {
        if (!assignmentModel.validatePrerequisites()) {
            return;
        }

        assignmentModel.fetchAvailableEntities();
    }

    public void displayEntities(List<ShipmentDTO> shipments, List<DriverDTO> drivers, List<LoaderDTO> loaders) {
        System.out.println("---- Shipments ----");
        for (ShipmentDTO shipment : shipments) {
            System.out.println(
                    "#" + shipment.getId() +
                            " | " + shipment.getTitle() +
                            " | Priority: " + shipment.getPriority() +
                            " | Status: " + shipment.getStatus() +
                            " | Driver: " + valueOrNA(shipment.getAssignedDriver()) +
                            " | Loader: " + valueOrNA(shipment.getAssignedLoader())
            );
        }

        long shipmentId = consoleInput.readLong("Shipment id to assign: ");

        System.out.println("---- Drivers ----");
        for (DriverDTO driver : drivers) {
            System.out.println("#" + driver.getId() + " | " + driver.getName() + " | " + driver.getLicenseNumber());
        }

        long driverId = consoleInput.readLong("Driver id: ");

        System.out.println("---- Loaders ----");
        for (LoaderDTO loader : loaders) {
            System.out.println("#" + loader.getId() + " | " + loader.getName());
        }

        long loaderId = consoleInput.readLong("Loader id: ");

        assignmentModel.assignShipment(shipmentId, driverId, loaderId);
    }

    public void onAssignmentSuccess() {
        System.out.println("Shipment assigned successfully.");
    }

    public void onError(String error) {
        System.out.println(error);
    }

    private String valueOrNA(Long value) {
        return value == null ? "N/A" : String.valueOf(value);
    }
}
