package com.uep.wap.dto;

public class ReportDTO {

    private Long id;
    private Long reportedById;
    private Long targetQuestionId;
    private Long targetAnswerId;
    private Long targetCommentId;
    private String reason;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReportedById() {
        return reportedById;
    }

    public void setReportedById(Long reportedById) {
        this.reportedById = reportedById;
    }

    public Long getTargetQuestionId() {
        return targetQuestionId;
    }

    public void setTargetQuestionId(Long targetQuestionId) {
        this.targetQuestionId = targetQuestionId;
    }

    public Long getTargetAnswerId() {
        return targetAnswerId;
    }

    public void setTargetAnswerId(Long targetAnswerId) {
        this.targetAnswerId = targetAnswerId;
    }

    public Long getTargetCommentId() {
        return targetCommentId;
    }

    public void setTargetCommentId(Long targetCommentId) {
        this.targetCommentId = targetCommentId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}