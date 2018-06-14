package agh.givealift.subs.service.implementation;


import agh.givealift.subs.model.entity.PushNotification;
import agh.givealift.subs.model.enums.DeviceType;
import agh.givealift.subs.model.request.PushNotificationRequest;
import agh.givealift.subs.model.response.PushNotificationResponse;
import agh.givealift.subs.model.response.PushNotificationResponses;
import agh.givealift.subs.model.response.PushSubscriptionResponse;
import agh.givealift.subs.model.response.SubscriptionResponse;
import agh.givealift.subs.repository.PushNotificationRepository;
import agh.givealift.subs.service.PushNotificationService;
import com.stefanik.cod.controller.COD;
import com.stefanik.cod.controller.CODFactory;
import com.stefanik.cod.controller.CODGlobal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PushNotificationServiceImpl implements PushNotificationService {
    private static final COD cod = CODFactory.get();
    private final PushNotificationRepository pushNotificationRepository;

    @Autowired
    public PushNotificationServiceImpl(
            PushNotificationRepository pushNotificationRepository
    ) {
        this.pushNotificationRepository = pushNotificationRepository;
        CODGlobal.setImmersionLevel(4);
    }

    @Override
    public Optional<PushNotification> add(PushNotificationRequest pushNotificationRequest) {

        List<PushNotification> result = pushNotificationRepository.findByPushTokenAndUserId(pushNotificationRequest.getPushToken(), pushNotificationRequest.getUserId());
        if (result.size() == 0) {
            PushNotification pushNotification = new PushNotification();

            pushNotification.setUserId(pushNotificationRequest.getUserId());
            pushNotification.setDeviceType(pushNotificationRequest.getDeviceType());
            pushNotification.setPushToken(pushNotificationRequest.getPushToken());


            pushNotification = pushNotificationRepository.save(pushNotification);
            cod.c().addShowToString(DeviceType.class).i("ADDED PUSH NOTIFICATION: ", pushNotification);
            return Optional.of(pushNotification);
        }
        return Optional.empty();
    }

    @Override
    public List<PushNotificationResponse> findNotification(List<SubscriptionResponse> subscriptionResponses) {

        List<PushNotificationResponse> pushNotificationResponses = new ArrayList<>();
        for (SubscriptionResponse sr : subscriptionResponses) {
            for (PushNotification pn : pushNotificationRepository.find(Long.parseLong(sr.getSubscriber()))) {
                PushNotificationResponse pnr = new PushNotificationResponse();
                pnr.setPushSubscriptionResponse(getPushSubscriptionResponse(sr));
                pnr.setToken(pn.getPushToken());
                pnr.setDeviceType(pn.getDeviceType());
                pushNotificationResponses.add(pnr);
            }
        }
        cod.i("FOUND PUSH NOTIFICATION RESPONSES: ", pushNotificationResponses);

        return pushNotificationResponses;
    }

    @Override
    public PushNotificationResponses findNotification2(List<SubscriptionResponse> subscriptionResponses) {
        if (subscriptionResponses.size() > 0) {
            ArrayList<String> l = new ArrayList<>();
            for (PushNotification pn : pushNotificationRepository.find(Long.parseLong(subscriptionResponses.get(0).getSubscriber()))) {
                l.add(pn.getPushToken());
            }
            PushNotificationResponses pnr = new PushNotificationResponses();
            pnr.setData(getPushSubscriptionResponse(subscriptionResponses.get(0)));
            pnr.setRegistration_ids(l);
            cod.i("FOUND PUSH NOTIFICATION RESPONSES2: ", pnr);
            return pnr;
        }
        return null;
    }

    private PushSubscriptionResponse getPushSubscriptionResponse(SubscriptionResponse sr) {
        PushSubscriptionResponse psr = new PushSubscriptionResponse();
        psr.setFromCityId(sr.getFrom().getCityId());
        psr.setToCityId(sr.getTo().getCityId());
        psr.setFromCityName(sr.getFrom().getName());
        psr.setToCityName(sr.getTo().getName());
        psr.setDate(sr.getDate());
        psr.setRouteId(sr.getRouteId());
        return psr;
    }

}
