package com.naveenkumarrm.moveX.feature.shipment;

import com.naveenkumarrm.moveX.data.dto.ShipmentDTO;
import com.naveenkumarrm.moveX.util.ConsoleInput;

import java.util.List;

public class ShipmentView {

    private final ShipmentModel shipmentModel;
    private final ConsoleInput consoleInput;

    public ShipmentView() {
        this.shipmentModel = new ShipmentModel(this);
        this.consoleInput = ConsoleInput.getInstance();
    }

    public void initCreate() {
        System.out.println("---- Create Shipment ----");
        String title = consoleInput.readText("Shipment title: ");
        String description = consoleInput.readText("Shipment description: ");
        String priority = consoleInput.readText("Priority (LOW/MEDIUM/HIGH): ").toUpperCase();

        shipmentModel.createShipment(title, description, priority);
    }

    public void initUpdate() {
        System.out.println("---- Update Shipment Status ----");
        shipmentModel.fetchShipments();
        long shipmentId = consoleInput.readLong("Shipment id to update: ");
        String status = consoleInput.readText("New status (IN_TRANSIT/DELIVERED/CANCELLED): ").toUpperCase();

        shipmentModel.updateShipmentStatus(shipmentId, status);
    }

    public void initUpdateLoadingStatus() {
        System.out.println("---- Update Loading Status ----");
        shipmentModel.fetchShipments();
        long shipmentId = consoleInput.readLong("Shipment id to update: ");
        String status = consoleInput.readText("New loading status (IN_PROGRESS/COMPLETED): ").toUpperCase();

        shipmentModel.updateShipmentLoadingStatus(shipmentId, status);
    }

    public void initList() {
        shipmentModel.fetchShipments();
    }

    public void onShipmentCreated(ShipmentDTO shipment) {
        System.out.println("Shipment created with id " + shipment.getId());
    }

    public void onShipmentsFetched(List<ShipmentDTO> shipments) {
        System.out.println("---- Shipments ----");
        for (ShipmentDTO shipment : shipments) {
            System.out.println(
                    "#" + shipment.getId() +
                            " | " + shipment.getTitle() +
                            " | Priority: " + shipment.getPriority() +
                            " | Status: " + shipment.getStatus() +
                            " | Loading Status: " + shipment.getLoadingStatus() +
                            " | Driver: " + valueOrNA(shipment.getAssignedDriver()) +
                            " | Loader: " + valueOrNA(shipment.getAssignedLoader())
            );
        }
    }

    public void onShipmentStatusUpdated() {
        System.out.println("Shipment status updated.");
    }

    public void onShipmentError(String error) {
        System.out.println(error);
    }

    private String valueOrNA(Long value) {
        return value == null ? "N/A" : String.valueOf(value);
    }
}
