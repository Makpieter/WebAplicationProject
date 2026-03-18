package com.uep.wap.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="reports ")
public class Report {
    @Id
    @Column(name ="id")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name ="reportedBy")
    private User reportedBy;
    @Column(name ="targetQuestion")
    private Question targetQuestion;
    @Column(name ="targetAnswer")
    private Answer targetAnswer;
    @Column(name ="targetComment")
    private Comment targetComment;
    @Column(name ="reason")
    private String reason;
    @Column(name ="status")
    private Enum status;

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

    public Enum getStatus() {
        return status;
    }

    public void setStatus(Enum status) {
        this.status = status;
    }

    public Report(){

    }
}


