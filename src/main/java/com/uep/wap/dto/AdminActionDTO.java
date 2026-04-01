package com.uep.wap.dto;

public class AdminActionDTO {

    private AdminActionType actionType;
    private Long targetUserId;
    private String targetSetting;
    private Long adminId;

    public AdminActionType getActionType() {
        return actionType;
    }

    public void setActionType(AdminActionType actionType) {
        this.actionType = actionType;
    }

    public Long getTargetUserId() {
        return targetUserId;
    }

    public void setTargetUserId(Long targetUserId) {
        this.targetUserId = targetUserId;
    }

    public String getTargetSetting() {
        return targetSetting;
    }

    public void setTargetSetting(String targetSetting) {
        this.targetSetting = targetSetting;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }
}