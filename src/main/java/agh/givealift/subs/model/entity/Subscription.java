package agh.givealift.subs.model.entity;

import agh.givealift.subs.model.enums.NotificationType;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Subscription {
    private Long subscriptionId;
    private String subscriber;
    private String email;
    private Long fromId;
    private Long toId;
    private Date date;
    @Enumerated(EnumType.STRING)
    private NotificationType notificationType;

    public Subscription() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Long subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(String subscriber) {
        this.subscriber = subscriber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getFromId() {
        return fromId;
    }

    public void setFromId(Long fromId) {
        this.fromId = fromId;
    }

    public Long getToId() {
        return toId;
    }

    public void setToId(Long toId) {
        this.toId = toId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }
}
