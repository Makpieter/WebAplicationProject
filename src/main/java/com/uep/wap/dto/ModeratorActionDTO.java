package com.uep.wap.dto;

import java.util.Date;

public class ModeratorActionDTO {

    private Long id;
    private String description;
    private String actionType;
    private Long targetQuestionId;
    private Long targetAnswerId;
    private Date createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}