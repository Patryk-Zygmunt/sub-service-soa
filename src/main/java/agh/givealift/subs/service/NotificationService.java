package agh.givealift.subs.service;


import agh.givealift.subs.model.response.PushNotificationResponse;
import agh.givealift.subs.model.response.PushNotificationResponses;
import agh.givealift.subs.model.response.SubscriptionResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NotificationService {
     void notifyBot(List<SubscriptionResponse> check);

     void notifyWeb(List<PushNotificationResponse> collect);

     void notifyMobile(List<PushNotificationResponse> collect);

     void notifyWeb2(PushNotificationResponses result);
}
