package com.uep.wap.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="ModeratorActions")
public class ModeratorAction {
    @Id
    @Column(name ="id")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name ="description")
    private String description;
    @Column(Enum ="actionType")
    private Enum actionType;
    @Column(name ="targetQuestion")
    private Question targetQuestion;
    @Column(name ="targetAnswer")
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

    public Enum getActionType() {
        return actionType;
    }

    public void setActionType(Enum actionType) {
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


