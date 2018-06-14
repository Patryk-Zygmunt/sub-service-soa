package agh.givealift.subs.model.request;

import agh.givealift.subs.model.entity.City;
import agh.givealift.subs.model.enums.NotificationType;

import java.util.Date;

public class SubscriptionRequest {
    private String subscriber;
    private String email;
    private City cityFrom;
    private City cityTo;
    private Date date;
    private NotificationType notificationType;

    public SubscriptionRequest() {
    }

    public String getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(String subscriber) {
        this.subscriber = subscriber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    public City getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(City cityFrom) {
        this.cityFrom = cityFrom;
    }

    public City getCityTo() {
        return cityTo;
    }

    public void setCityTo(City cityTo) {
        this.cityTo = cityTo;
    }
}
