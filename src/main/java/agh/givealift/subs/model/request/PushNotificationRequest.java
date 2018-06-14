package agh.givealift.subs.model.request;

import agh.givealift.subs.model.enums.DeviceType;
import agh.givealift.subs.model.enums.NotificationType;

import java.util.Date;

public class PushNotificationRequest {
    private String pushToken;
    private Long userId;
    private DeviceType deviceType;

    public String getPushToken() {
        return pushToken;
    }

    public void setPushToken(String pushToken) {
        this.pushToken = pushToken;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }
}
