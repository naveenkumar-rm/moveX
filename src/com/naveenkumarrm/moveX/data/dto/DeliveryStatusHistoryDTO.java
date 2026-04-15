package com.naveenkumarrm.moveX.data.dto;

public class DeliveryStatusHistoryDTO {
    private Long id;
    private Long shipmentId;
    private Long updatedBy;
    private String oldStatus;
    private String newStatus;
    private String remarks;
    private Long updatedTime;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getShipmentId() { return shipmentId; }
    public void setShipmentId(Long shipmentId) { this.shipmentId = shipmentId; }

    public Long getUpdatedBy() { return updatedBy; }
    public void setUpdatedBy(Long updatedBy) { this.updatedBy = updatedBy; }

    public String getOldStatus() { return oldStatus; }
    public void setOldStatus(String oldStatus) { this.oldStatus = oldStatus; }

    public String getNewStatus() { return newStatus; }
    public void setNewStatus(String newStatus) { this.newStatus = newStatus; }

    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }

    public Long getUpdatedTime() { return updatedTime; }
    public void setUpdatedTime(Long updatedTime) { this.updatedTime = updatedTime; }
}