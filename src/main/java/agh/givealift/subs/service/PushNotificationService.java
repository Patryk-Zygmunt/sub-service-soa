package agh.givealift.subs.service;


import agh.givealift.subs.model.entity.PushNotification;
import agh.givealift.subs.model.request.PushNotificationRequest;
import agh.givealift.subs.model.response.PushNotificationResponse;
import agh.givealift.subs.model.response.PushNotificationResponses;
import agh.givealift.subs.model.response.SubscriptionResponse;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PushNotificationService {

    Optional<PushNotification> add(PushNotificationRequest pushNotificationRequest);

    List<PushNotificationResponse> findNotification(List<SubscriptionResponse> collect);

    PushNotificationResponses findNotification2(List<SubscriptionResponse> collect);
}
