package com.uep.wap.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="AdminActions")
public class AdminAction {
    @Id
    @Column(name ="id")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name ="actionType")
    private Enum actionType;
    @Column(name ="targetUser")
    private User targetUser;
    @Column(name ="targetSetting")
    private String targetSetting;
    @Column(name ="actionTakenBy")
    private User actionTakenBy;
    @Column(name ="createdAt")
    private Date createdAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Enum getActionType() {
        return actionType;
    }

    public void setActionType(Enum actionType) {
        this.actionType = actionType;
    }

    public User getTargetUser() {
        return targetUser;
    }

    public void setTargetUser(User targetUser) {
        this.targetUser = targetUser;
    }

    public String getTargetSetting() {
        return targetSetting;
    }

    public void setTargetSetting(String targetSetting) {
        this.targetSetting = targetSetting;
    }

    public User getActionTakenBy() {
        return actionTakenBy;
    }

    public void setActionTakenBy(User actionTakenBy) {
        this.actionTakenBy = actionTakenBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public AdminAction(){

    }
}


