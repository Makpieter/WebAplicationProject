package com.uep.wap.controller;

import com.uep.wap.model.Report;
import com.uep.wap.service.ReportService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping(path = "/reports")
    public Iterable<Report> getAllReports() {
        return reportService.getAllReports();
    }

    @PostMapping(path = "/reports")
    public String addReport(@RequestBody Report reportDTO) {
        reportService.addReport(reportDTO);
        return "Report added!";
    }
}