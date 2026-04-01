package com.uep.wap.controller;

import com.uep.wap.dto.ReportDTO;
import com.uep.wap.model.Report;
import com.uep.wap.service.ReportsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class ReportController {

    private final ReportsService reportsService;

    public ReportController(ReportsService reportsService) {
        this.reportsService = reportsService;
    }

    @GetMapping(path = "/reports")
    public Iterable<Report> getAllReports() {
        return reportsService.getAllReports();
    }

    @PostMapping(path = "/reports")
    public String addReport(@RequestBody ReportDTO reportDTO) {
        reportsService.addReport(reportDTO);
        return "Report added!";
    }
}