package agh.givealift.subs.model.entity;

import agh.givealift.subs.model.enums.DeviceType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PushNotification {
    private Long pushNotificationId;
    private String pushToken;
    private Long userId;
    private DeviceType deviceType;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getPushNotificationId() {
        return pushNotificationId;
    }

    public void setPushNotificationId(Long pushNotificationId) {
        this.pushNotificationId = pushNotificationId;
    }

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
