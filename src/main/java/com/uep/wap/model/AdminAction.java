package com.uep.wap.model;

import com.uep.wap.dto.AdminActionType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="admin_actions")
public class AdminAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name ="action_type")
    private AdminActionType actionType;

    @ManyToOne
    @JoinColumn(name = "target_user_id")
    private User targetUser;

    @Column(name ="target_setting")
    private String targetSetting;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private User actionTakenBy;

    @Column(name ="created_at")
    private Date createdAt;

    public long getId() {
        return id;
    }

    public AdminActionType getActionType() {
        return actionType;
    }

    public void setActionType(AdminActionType actionType) {
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

    public AdminAction() {}
}