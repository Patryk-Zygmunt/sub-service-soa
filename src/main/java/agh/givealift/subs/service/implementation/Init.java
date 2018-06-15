package agh.givealift.subs.service.implementation;

import agh.givealift.subs.model.entity.Subscription;
import agh.givealift.subs.model.enums.NotificationType;
import agh.givealift.subs.model.request.PushNotificationRequest;
import agh.givealift.subs.model.request.SubscriptionRequest;
import agh.givealift.subs.service.PushNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service public class Init {
    @Autowired SubscriptionServiceImpl subscriptionService;
    @Autowired PushNotificationService pushNotificationService;

    @PostConstruct public void init() {
        SubscriptionRequest sub = new SubscriptionRequest();
        sub.setToId(9L);
        sub.setFromId(12L);
        sub.setDate(new Date());
        sub.setEmail("emial@.m.pl");
        sub.setNotificationType(NotificationType.BOT);
        subscriptionService.add(sub);

        PushNotificationRequest pushNotificationRequest = new PushNotificationRequest();
        pushNotificationRequest.setUserId(102L);
        //    pushNotificationRequest.setPushToken();   ?
        pushNotificationService.add(pushNotificationRequest);

    }
}
