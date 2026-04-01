package com.uep.wap.service;

import com.uep.wap.model.Report;
import com.uep.wap.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public void addReport(Report reportDTO) {
        Report report = new Report();
        report.setId(reportDTO.getId());
        report.setReportedBy(reportDTO.getReportedBy());
        report.setTargetQuestion(reportDTO.getTargetQuestion());
        report.setTargetAnswer(reportDTO.getTargetAnswer());
        report.setTargetComment(reportDTO.getTargetComment());
        report.setReason(reportDTO.getReason());
        report.setStatus(reportDTO.getStatus());
        reportRepository.save(report);
        System.out.println("Report added!");
    }

    public Iterable<Report> getAllReports() {
        return reportRepository.findAll();
    }
}