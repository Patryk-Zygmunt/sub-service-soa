package agh.givealift.subs.model.response;

import java.util.List;

public class PushNotificationResponses {
    private PushSubscriptionResponse data;
    private List<String> registration_ids;

    public PushNotificationResponses() {
    }

    public PushSubscriptionResponse getData() {
        return data;
    }

    public void setData(PushSubscriptionResponse data) {
        this.data = data;
    }

    public List<String> getRegistration_ids() {
        return registration_ids;
    }

    public void setRegistration_ids(List<String> registration_ids) {
        this.registration_ids = registration_ids;
    }
}
