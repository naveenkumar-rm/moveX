package com.naveenkumarrm.moveX.data.dto;

public class Shipment {

    private Long id;
    private String title;
    private String description;

    private Long createdBy;
    private Long assignedDriverId;
    private Long assignedLoaderId;

    private Priority priority;
    private Status status;
    private LoadingStatus loadingStatus;

    private long createdTime;
    private long updatedTime;
    private long completedTime;

    public enum Priority {
        URGENT,
        NORMAL,
        DELAYED
    }

    public enum Status {
        PENDING,
        IN_TRANSIT,
        COMPLETED
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getAssignedDriverId() {
        return assignedDriverId;
    }

    public void setAssignedDriverId(Long assignedDriverId) {
        this.assignedDriverId = assignedDriverId;
    }

    public Long getAssignedLoaderId() {
        return assignedLoaderId;
    }

    public void setAssignedLoaderId(Long assignedLoaderId) {
        this.assignedLoaderId = assignedLoaderId;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LoadingStatus getLoadingStatus() {
        return loadingStatus;
    }

    public void setLoadingStatus(LoadingStatus loadingStatus) {
        this.loadingStatus = loadingStatus;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    public long getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(long updatedTime) {
        this.updatedTime = updatedTime;
    }

    public long getCompletedTime() {
        return completedTime;
    }

    public void setCompletedTime(long completedTime) {
        this.completedTime = completedTime;
    }


}