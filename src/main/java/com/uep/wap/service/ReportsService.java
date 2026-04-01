package com.uep.wap.service;

import com.uep.wap.dto.ReportDTO;
import com.uep.wap.dto.ReportStatus;
import com.uep.wap.model.*;
import com.uep.wap.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportsService {

    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private CommentRepository commentRepository;

    public void addReport(ReportDTO dto) {
        Report report = new Report();

        User reporter = userRepository.findById(dto.getReportedById())
                .orElseThrow(() -> new RuntimeException("User not found"));
        report.setReportedBy(reporter);

        if (dto.getTargetQuestionId() != null) {
            Question q = questionRepository.findById(dto.getTargetQuestionId())
                    .orElseThrow(() -> new RuntimeException("Question not found"));
            report.setTargetQuestion(q);
        }

        if (dto.getTargetAnswerId() != null) {
            Answer a = answerRepository.findById(dto.getTargetAnswerId())
                    .orElseThrow(() -> new RuntimeException("Answer not found"));
            report.setTargetAnswer(a);
        }

        if (dto.getTargetCommentId() != null) {
            Comment c = commentRepository.findById(dto.getTargetCommentId())
                    .orElseThrow(() -> new RuntimeException("Comment not found"));
            report.setTargetComment(c);
        }

        report.setReason(dto.getReason());
        report.setStatus(ReportStatus.valueOf(dto.getStatus()));

        reportRepository.save(report);
        System.out.println("Report added!");
    }

    public Iterable<Report> getAllReports() {
        return reportRepository.findAll();
    }
}