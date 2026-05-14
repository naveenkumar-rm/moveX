# 📦 Logistics Management System (LMS)

---

## 📌 Requirement Gathering / Analysis

* User registration & login
* Role-based access (Employee, Driver, Loader)
* Add / manage shipment orders
* View shipment list
* Assign orders to drivers & loaders
* Update shipment status (Pending / In Transit / Delivered)
* Simple dashboard (total orders, delivered, pending)
* Driver account creation
* Loader account creation
* View driver & loader details
* Shipment priority setting (urgent / normal / delayed)
* Search & filter shipments
* Delivery date & time tracking
* Simple report generation (daily / weekly)
* Logout functionality

---

## 🚀 Future Scope

* Route optimization (Maps API integration)
* Real-time GPS tracking
* SMS/Email notification system
* Proof of delivery (image/signature upload)
* Advanced cost and fuel tracking

---

## 🛠 Tech Stack

* Java
* SQL

⏱ Time: 1 Month
👤 Team Members: 1

---

## ⭐ Features

### 👨‍💼 Employee

* Create & manage drivers, loaders
* View all drivers & loaders
* Create shipments
* Assign shipments to drivers & loaders
* Track shipment status
* Access inventory / warehouse data

---

### 🚚 Driver

* View assigned deliveries (My Delivery List)
* View current & completed deliveries
* Update delivery status (Start delivery / Mark as completed)

---

### 📦 Loader

* View assigned loading/unloading tasks
* Update loading status (Not Loaded / Loaded / Unloaded)
* Assist in shipment preparation
* Update shipment readiness for dispatch

---

## 🧱 Model Classes

### 📦 Shipment

* id: Long
* title: String
* description: String
* createdBy: Long (FK - Employee.id)
* assignedDriver: Long (FK - Driver.id)
* assignedLoader: Long (FK - Loader.id)
* priority: Enum (URGENT / NORMAL / DELAYED)
* status: Enum (PENDING / IN_TRANSIT / COMPLETED)
* loadingStatus: Enum (NOT_LOADED / LOADED / UNLOADED)
* createdTime: Long
* updatedTime: Long
* completedTime: Long

---

### 👨‍💼 Employee

* id: Long
* employeeId: String
* name: String
* email: String
* password: String (hashed)
* mobileNo: String
* role: Enum (MANAGER / EMPLOYEE)
* status: Enum (ACTIVE / INACTIVE)
* createdAt: Long

---

### 🚚 Driver

* id: Long
* name: String
* email: String
* mobileNo: String
* licenseNumber: String
* status: Enum (AVAILABLE / BUSY / INACTIVE)
* createdAt: Long

---

### 📦 Loader

* id: Long
* name: String
* mobileNo: String
* status: Enum (AVAILABLE / BUSY / INACTIVE)
* createdAt: Long

---

### 📦 Inventory

* id: Long
* itemName: String
* quantity: int
* location: String
* lastUpdated: Long

---

### 🔗 Assignment

* id: Long
* shipmentId: Long (FK - Shipment.id)
* driverId: Long (FK - Driver.id)
* loaderId: Long (FK - Loader.id)
* assignedTime: Long

---

### 📊 DeliveryStatusHistory

* id: Long
* shipmentId: Long (FK - Shipment.id)
* updatedBy: Long (FK - Driver.id)
* oldStatus: Enum (PENDING / IN_TRANSIT / COMPLETED)
* newStatus: Enum (PENDING / IN_TRANSIT / COMPLETED)
* remarks: String
* updatedTime: Long

---

### 📊 LoadingStatusHistory

* id: Long
* shipmentId: Long (FK - Shipment.id)
* updatedBy: Long (FK - Loader.id)
* oldStatus: Enum (NOT_LOADED / LOADED / UNLOADED)
* newStatus: Enum (NOT_LOADED / LOADED / UNLOADED)
* remarks: String
* updatedTime: Long

---

### 🔐 LoginRequest

* email: String
* password: String

---

### 📈 Report

* id: Long
* totalShipments: int
* completedShipments: int
* delayedShipments: int
* generatedTime: Long

---

## 📊 UML Diagram

<img width="1425" height="1427" alt="Logisticmanagementsysytem" src="https://github.com/user-attachments/assets/86ee3e2b-4e98-41ba-8fb5-d052b77d3857" />


```

---
