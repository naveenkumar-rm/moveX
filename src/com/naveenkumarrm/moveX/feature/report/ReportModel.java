package com.naveenkumarrm.moveX.feature.report;

import com.naveenkumarrm.moveX.data.dto.ReportDTO;
import com.naveenkumarrm.moveX.data.dto.ShipmentDTO;
import com.naveenkumarrm.moveX.data.repository.MoveXDB;

import java.util.Map;

public class ReportModel {

    private final ReportView reportView;

    public ReportModel(ReportView reportView) {
        this.reportView = reportView;
    }

    public void generateReport() {
        Map<Long, ShipmentDTO> shipments = MoveXDB.getInstance().getShipments();

        ReportDTO report = new ReportDTO();
        report.setId(1L);
        report.setTotalShipments(shipments.size());

        int completed = 0;
        int delayed = 0;
        for (ShipmentDTO shipment : shipments.values()) {
            if ("DELIVERED".equalsIgnoreCase(shipment.getStatus())) {
                completed++;
            } else if ("IN_TRANSIT".equalsIgnoreCase(shipment.getStatus())) {
                delayed++;
            }
        }

        report.setCompletedShipments(completed);
        report.setDelayedShipments(delayed);
        report.setGeneratedTime(System.currentTimeMillis());

        int activeDrivers = MoveXDB.getInstance().getDrivers().size();
        int activeLoaders = MoveXDB.getInstance().getLoaders().size();

        reportView.onReportGenerated(report, activeDrivers, activeLoaders);
    }
}
