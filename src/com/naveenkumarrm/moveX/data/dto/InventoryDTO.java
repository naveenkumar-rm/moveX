package com.naveenkumarrm.moveX.data.dto;

public class InventoryDTO {
    private Long id;
    private String itemName;
    private int quantity;
    private String location;
    private Long lastUpdated;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public Long getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(Long lastUpdated) { this.lastUpdated = lastUpdated; }
}