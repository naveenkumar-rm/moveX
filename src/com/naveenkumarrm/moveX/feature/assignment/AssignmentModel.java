package com.naveenkumarrm.moveX.feature.assignment;

import com.naveenkumarrm.moveX.data.dto.DriverDTO;
import com.naveenkumarrm.moveX.data.dto.LoaderDTO;
import com.naveenkumarrm.moveX.data.dto.ShipmentDTO;
import com.naveenkumarrm.moveX.data.repository.MoveXDB;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class AssignmentModel {

    private final AssignmentView assignmentView;

    public AssignmentModel(AssignmentView assignmentView) {
        this.assignmentView = assignmentView;
    }

    public boolean validatePrerequisites() {
        if (MoveXDB.getInstance().getShipments().isEmpty()) {
            assignmentView.onError("No shipment found.");
            return false;
        }
        if (MoveXDB.getInstance().getDrivers().isEmpty() || MoveXDB.getInstance().getLoaders().isEmpty()) {
            assignmentView.onError("Create at least one driver and one loader before assignment.");
            return false;
        }
        return true;
    }

    public void fetchAvailableEntities() {
        List<ShipmentDTO> shipments = new ArrayList<>(MoveXDB.getInstance().getShipments().values());
        shipments.sort(Comparator.comparingLong(ShipmentDTO::getId));

        List<DriverDTO> drivers = new ArrayList<>(MoveXDB.getInstance().getDrivers().values());
        List<LoaderDTO> loaders = new ArrayList<>(MoveXDB.getInstance().getLoaders().values());

        assignmentView.displayEntities(shipments, drivers, loaders);
    }

    public void assignShipment(long shipmentId, long driverId, long loaderId) {
        ShipmentDTO shipment = MoveXDB.getInstance().getShipment(shipmentId);
        if (shipment == null) {
            assignmentView.onError("Invalid shipment id.");
            return;
        }

        if (!MoveXDB.getInstance().getDrivers().containsKey(driverId)) {
            assignmentView.onError("Invalid driver id.");
            return;
        }

        if (!MoveXDB.getInstance().getLoaders().containsKey(loaderId)) {
            assignmentView.onError("Invalid loader id.");
            return;
        }

        shipment.setAssignedDriver(driverId);
        shipment.setAssignedLoader(loaderId);
        shipment.setStatus("ASSIGNED");
        shipment.setUpdatedTime(System.currentTimeMillis());

        assignmentView.onAssignmentSuccess();
    }
}
