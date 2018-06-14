package agh.givealift.subs.repository;

import agh.givealift.subs.model.entity.PushNotification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PushNotificationRepository extends JpaRepository<PushNotification, Long> {


    @Query("select p from PushNotification p WHERE p.userId in (:id)")
    List<PushNotification> find(@Param(value = "id") Long id);

    List<PushNotification> findByPushTokenAndUserId(String token, Long userId);

}
