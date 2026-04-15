package com.naveenkumarrm.moveX.data.dto;

public class ReportDTO {

    private Long id;
    private int totalShipments;
    private int completedShipments;
    private int delayedShipments;
    private long generatedTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTotalShipments() {
        return totalShipments;
    }

    public void setTotalShipments(int totalShipments) {
        this.totalShipments = totalShipments;
    }

    public int getCompletedShipments() {
        return completedShipments;
    }

    public void setCompletedShipments(int completedShipments) {
        this.completedShipments = completedShipments;
    }

    public int getDelayedShipments() {
        return delayedShipments;
    }

    public void setDelayedShipments(int delayedShipments) {
        this.delayedShipments = delayedShipments;
    }

    public long getGeneratedTime() {
        return generatedTime;
    }

    public void setGeneratedTime(long generatedTime) {
        this.generatedTime = generatedTime;
    }
}