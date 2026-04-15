package com.naveenkumarrm.moveX.data.dto;

public class AssignmentDTO {

    private Long id;
    private Long shipmentId;
    private Long driverId;
    private Long loaderId;
    private long assignedTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(Long shipmentId) {
        this.shipmentId = shipmentId;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public Long getLoaderId() {
        return loaderId;
    }

    public void setLoaderId(Long loaderId) {
        this.loaderId = loaderId;
    }

    public long getAssignedTime() {
        return assignedTime;
    }

    public void setAssignedTime(long assignedTime) {
        this.assignedTime = assignedTime;
    }
}