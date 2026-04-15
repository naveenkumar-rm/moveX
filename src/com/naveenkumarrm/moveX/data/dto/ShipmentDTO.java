package com.naveenkumarrm.moveX.data.dto;

public class ShipmentDTO {
    private Long id;
    private String title;
    private String description;
    private Long createdBy;
    private Long assignedDriver;
    private Long assignedLoader;
    private String priority;
    private String status;
    private String loadingStatus;
    private Long createdTime;
    private Long updatedTime;
    private Long completedTime;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Long getCreatedBy() { return createdBy; }
    public void setCreatedBy(Long createdBy) { this.createdBy = createdBy; }

    public Long getAssignedDriver() { return assignedDriver; }
    public void setAssignedDriver(Long assignedDriver) { this.assignedDriver = assignedDriver; }

    public Long getAssignedLoader() { return assignedLoader; }
    public void setAssignedLoader(Long assignedLoader) { this.assignedLoader = assignedLoader; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getLoadingStatus() { return loadingStatus; }
    public void setLoadingStatus(String loadingStatus) { this.loadingStatus = loadingStatus; }

    public Long getCreatedTime() { return createdTime; }
    public void setCreatedTime(Long createdTime) { this.createdTime = createdTime; }

    public Long getUpdatedTime() { return updatedTime; }
    public void setUpdatedTime(Long updatedTime) { this.updatedTime = updatedTime; }

    public Long getCompletedTime() { return completedTime; }
    public void setCompletedTime(Long completedTime) { this.completedTime = completedTime; }
}