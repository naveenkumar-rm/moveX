package com.naveenkumarrm.moveX.feature.dashboard;

import com.naveenkumarrm.moveX.feature.assignment.AssignmentView;
import com.naveenkumarrm.moveX.feature.driver.DriverView;
import com.naveenkumarrm.moveX.feature.loader.LoaderView;
import com.naveenkumarrm.moveX.feature.report.ReportView;
import com.naveenkumarrm.moveX.feature.shipment.ShipmentView;
import com.naveenkumarrm.moveX.util.ConsoleInput;
import com.naveenkumarrm.moveX.util.SessionManager;

public class DashboardView {
    private final ConsoleInput consoleInput = ConsoleInput.getInstance();

    public void init() {
        String role = SessionManager.getInstance().getLoggedInRole();
        System.out.println("Welcome, " + SessionManager.getInstance().getLoggedInName() + "!");
        boolean running = true;
        while (running) {
            if ("EMPLOYEE".equals(role)) {
                running = showEmployeeDashboard();
            } else if ("DRIVER".equals(role)) {
                running = showDriverDashboard();
            } else if ("LOADER".equals(role)) {
                running = showLoaderDashboard();
            } else {
                running = false;
            }
        }
        SessionManager.getInstance().logout();
        System.out.println("Logged out successfully.");
    }

    private boolean showEmployeeDashboard() {
        System.out.println("---- Employee Dashboard ----");
        System.out.println("1. Add Driver");
        System.out.println("2. Add Loader");
        System.out.println("3. Create Shipment");
        System.out.println("4. Assign Shipment");
        System.out.println("5. Update Shipment Status");
        System.out.println("6. List Shipments");
        System.out.println("7. Generate Report");
        System.out.println("0. Logout");

        int option = consoleInput.readInt("Choose option: ");
        switch (option) {
            case 1: new DriverView().init(); break;
            case 2: new LoaderView().init(); break;
            case 3: new ShipmentView().initCreate(); break;
            case 4: new AssignmentView().init(); break;
            case 5: new ShipmentView().initUpdate(); break;
            case 6: new ShipmentView().initList(); break;
            case 7: new ReportView().init(); break;
            case 0: return false;
            default: System.out.println("Invalid option.");
        }
        return true;
    }

    private boolean showDriverDashboard() {
        System.out.println("---- Driver Dashboard ----");
        System.out.println("1. List Assigned Shipments");
        System.out.println("2. Update Shipment Status");
        System.out.println("0. Logout");

        int option = consoleInput.readInt("Choose option: ");
        switch (option) {
            case 1: new ShipmentView().initList(); break;
            case 2: new ShipmentView().initUpdate(); break;
            case 0: return false;
            default: System.out.println("Invalid option.");
        }
        return true;
    }

    private boolean showLoaderDashboard() {
        System.out.println("---- Loader Dashboard ----");
        System.out.println("1. List Assigned Shipments");
        System.out.println("2. Update Loading Status");
        System.out.println("0. Logout");

        int option = consoleInput.readInt("Choose option: ");
        switch (option) {
            case 1: new ShipmentView().initList(); break;
            case 2: new ShipmentView().initUpdateLoadingStatus(); break;
            case 0: return false;
            default: System.out.println("Invalid option.");
        }
        return true;
    }
}
