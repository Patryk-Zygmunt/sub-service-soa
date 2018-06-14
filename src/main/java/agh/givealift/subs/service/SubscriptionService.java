package agh.givealift.subs.service;


import agh.givealift.subs.model.Route;
import agh.givealift.subs.model.entity.Subscription;
import agh.givealift.subs.model.request.SubscriptionRequest;
import agh.givealift.subs.model.response.SubscriptionResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface SubscriptionService {

    Optional<Subscription> add(SubscriptionRequest subscriptionRequest);

    void checkAndNotify(Route route);

    List<Subscription> getAll();
    SubscriptionResponse mapToSubscriptionResponse(Subscription subscription) ;


    Long delete(long id);
}
