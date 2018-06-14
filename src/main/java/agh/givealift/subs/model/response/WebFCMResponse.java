package agh.givealift.subs.model.response;



public class WebFCMResponse {
    private PushSubscriptionResponse data;
    private String to;

    public WebFCMResponse() {
    }

    public WebFCMResponse(PushNotificationResponse pnr) {
        this.data = pnr.getPushSubscriptionResponse();
        this.to = pnr.getToken();
    }

    public PushSubscriptionResponse getData() {
        return data;
    }

    public void setData(PushSubscriptionResponse data) {
        this.data = data;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
