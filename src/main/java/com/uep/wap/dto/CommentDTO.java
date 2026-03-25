package com.uep.wap.dto;

import java.util.Date;

public class CommentDTO {

    private Long id;
    private String content;
    private Long authorId;
    private Date createdAt;
    private Date updatedAt;
    private Long targetQuestionId;
    private Long targetAnswerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
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
}