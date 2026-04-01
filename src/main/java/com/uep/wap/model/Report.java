package com.uep.wap.model;

import com.uep.wap.dto.ReportStatus;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="reports ")
public class Report {
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "reportedBy")
    private User reportedBy;
    @ManyToOne
    @JoinColumn(name = "targetQuestion")
    private Question targetQuestion;
    @ManyToOne
    @JoinColumn(name = "targetAnswer")
    private Answer targetAnswer;
    @ManyToOne
    @JoinColumn(name = "targetComment")
    private Comment targetComment;
    @Column(name ="reason")
    private String reason;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ReportStatus status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(User reportedBy) {
        this.reportedBy = reportedBy;
    }

    public Question getTargetQuestion() {
        return targetQuestion;
    }

    public void setTargetQuestion(Question targetQuestion) {
        this.targetQuestion = targetQuestion;
    }

    public Answer getTargetAnswer() {
        return targetAnswer;
    }

    public void setTargetAnswer(Answer targetAnswer) {
        this.targetAnswer = targetAnswer;
    }

    public Comment getTargetComment() {
        return targetComment;
    }

    public void setTargetComment(Comment targetComment) {
        this.targetComment = targetComment;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ReportStatus getStatus() {
        return status;
    }

    public void setStatus(ReportStatus status) {
        this.status = status;
    }

    public Report(){

    }
}


