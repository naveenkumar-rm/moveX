package com.naveenkumarrm.moveX.feature.shipment;

import com.naveenkumarrm.moveX.data.dto.ShipmentDTO;
import com.naveenkumarrm.moveX.data.repository.MoveXDB;
import com.naveenkumarrm.moveX.util.SessionManager;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ShipmentModel {

    private final ShipmentView shipmentView;

    public ShipmentModel(ShipmentView shipmentView) {
        this.shipmentView = shipmentView;
    }

    public void createShipment(String title, String description, String priority) {
        ShipmentDTO shipment = new ShipmentDTO();
        shipment.setId(MoveXDB.getInstance().getNextShipmentId());
        shipment.setTitle(title);
        shipment.setDescription(description);
        shipment.setPriority(priority);
        shipment.setStatus("CREATED");
        shipment.setLoadingStatus("PENDING");
        shipment.setCreatedBy(SessionManager.getInstance().getLoggedInId());
        shipment.setCreatedTime(System.currentTimeMillis());
        shipment.setUpdatedTime(shipment.getCreatedTime());

        MoveXDB.getInstance().addShipment(shipment);
        shipmentView.onShipmentCreated(shipment);
    }

    public void updateShipmentStatus(long shipmentId, String newStatus) {
        ShipmentDTO shipment = getShipmentIfAuthorized(shipmentId);
        if (shipment == null) {
            return;
        }

        shipment.setStatus(newStatus);
        shipment.setUpdatedTime(System.currentTimeMillis());

        if ("DELIVERED".equals(newStatus)) {
            shipment.setCompletedTime(System.currentTimeMillis());
        }

        shipmentView.onShipmentStatusUpdated();
    }

    public void updateShipmentLoadingStatus(long shipmentId, String newLoadingStatus) {
        ShipmentDTO shipment = getShipmentIfAuthorized(shipmentId);
        if (shipment == null) {
            return;
        }

        shipment.setLoadingStatus(newLoadingStatus);
        shipment.setUpdatedTime(System.currentTimeMillis());

        shipmentView.onShipmentStatusUpdated();
    }

    private ShipmentDTO getShipmentIfAuthorized(long shipmentId) {
        ShipmentDTO shipment = MoveXDB.getInstance().getShipment(shipmentId);
        if (shipment == null) {
            shipmentView.onShipmentError("Invalid shipment id.");
            return null;
        }

        String role = SessionManager.getInstance().getLoggedInRole();
        Long loggedInId = SessionManager.getInstance().getLoggedInId();

        if ("DRIVER".equals(role) && !loggedInId.equals(shipment.getAssignedDriver())) {
            shipmentView.onShipmentError("You are not assigned to this shipment.");
            return null;
        }

        if ("LOADER".equals(role) && !loggedInId.equals(shipment.getAssignedLoader())) {
            shipmentView.onShipmentError("You are not assigned to this shipment.");
            return null;
        }

        return shipment;
    }

    public void fetchShipments() {
        Map<Long, ShipmentDTO> shipments = MoveXDB.getInstance().getShipments();
        List<ShipmentDTO> list = new ArrayList<>();

        String role = SessionManager.getInstance().getLoggedInRole();
        Long loggedInId = SessionManager.getInstance().getLoggedInId();

        for (ShipmentDTO shipment : shipments.values()) {
            if ("DRIVER".equals(role) && !loggedInId.equals(shipment.getAssignedDriver())) {
                continue;
            }
            if ("LOADER".equals(role) && !loggedInId.equals(shipment.getAssignedLoader())) {
                continue;
            }
            list.add(shipment);
        }

        if (list.isEmpty()) {
            shipmentView.onShipmentError("No shipment found.");
            return;
        }

        list.sort(Comparator.comparingLong(ShipmentDTO::getId));
        shipmentView.onShipmentsFetched(list);
    }
}
