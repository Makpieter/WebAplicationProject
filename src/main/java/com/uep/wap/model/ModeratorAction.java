package com.uep.wap.model;

import com.uep.wap.dto.ModeratorActionType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="ModeratorActions")
public class ModeratorAction {
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name ="description")
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "actionType")
    private ModeratorActionType actionType;
    @ManyToOne
    @JoinColumn(name = "targetQuestion")
    private Question targetQuestion;
    @ManyToOne
    @JoinColumn(name = "targetAnswer")
    private Answer targetAnswer;
    @Column(name ="createdAt")
    private Date createdAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ModeratorActionType getActionType() {
        return actionType;
    }

    public void setActionType(ModeratorActionType actionType) {
        this.actionType = actionType;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public ModeratorAction(){

    }
}


