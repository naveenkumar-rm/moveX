package com.naveenkumarrm.moveX.data.dto;

public class LoadingStatusHistory {

    private Long id;
    private Long shipmentId;
    private Long updatedBy;
    private LoadingStatus loadingStatus;
    private String remarks;
    private long updatedTime;

    public enum LoadingStatus {
        NOT_LOADED,
        LOADED,
        UNLOADED
    }

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

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LoadingStatus getLoadingStatus() {
        return loadingStatus;
    }

    public void setLoadingStatus(LoadingStatus loadingStatus) {
        this.loadingStatus = loadingStatus;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public long getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(long updatedTime) {
        this.updatedTime = updatedTime;
    }
}