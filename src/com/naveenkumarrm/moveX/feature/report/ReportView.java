package com.naveenkumarrm.moveX.feature.report;

import com.naveenkumarrm.moveX.data.dto.ReportDTO;

public class ReportView {

    private final ReportModel reportModel;

    public ReportView() {
        this.reportModel = new ReportModel(this);
    }

    public void init() {
        reportModel.generateReport();
    }

    public void onReportGenerated(ReportDTO report, int activeDrivers, int activeLoaders) {
        System.out.println("---- Report ----");
        System.out.println("Total Shipments   : " + report.getTotalShipments());
        System.out.println("Completed         : " + report.getCompletedShipments());
        System.out.println("In Transit/Delayed: " + report.getDelayedShipments());
        System.out.println("Active Drivers    : " + activeDrivers);
        System.out.println("Active Loaders    : " + activeLoaders);
    }
}
