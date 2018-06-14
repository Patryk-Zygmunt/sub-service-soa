package agh.givealift.subs.service.implementation;


import agh.givealift.subs.model.response.PushNotificationResponse;
import agh.givealift.subs.model.response.PushNotificationResponses;
import agh.givealift.subs.model.response.SubscriptionResponse;
import agh.givealift.subs.model.response.WebFCMResponse;
import agh.givealift.subs.service.NotificationService;
import agh.givealift.subs.service.threads.NotifyBotThread;
import agh.givealift.subs.service.threads.NotifyMobileThread;
import agh.givealift.subs.service.threads.NotifyOneWebThread;
import agh.givealift.subs.service.threads.NotifyWebThread;
import com.stefanik.cod.controller.COD;
import com.stefanik.cod.controller.CODFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {
    private static final COD cod = CODFactory.get();
    private final ApplicationContext applicationContext;
    private final TaskExecutor taskExecutor;

    @Autowired
    public NotificationServiceImpl(ApplicationContext applicationContext, TaskExecutor taskExecutor) {
        this.applicationContext = applicationContext;
        this.taskExecutor = taskExecutor;
    }


    @Override
    public void notifyBot(List<SubscriptionResponse> subscriptionResponseList) {
        if (!subscriptionResponseList.isEmpty()) {
            taskExecutor.execute(() -> {
                NotifyBotThread notifyThread = applicationContext.getBean(NotifyBotThread.class);
                notifyThread.setSubscriptionResponseList(subscriptionResponseList);
                taskExecutor.execute(notifyThread);
            });
        }
    }

    @Override
    public void notifyWeb(List<PushNotificationResponse> pushNotificationResponses) {




        for (PushNotificationResponse pnr : pushNotificationResponses) {
            taskExecutor.execute(() -> {
                NotifyOneWebThread notifyThread = applicationContext.getBean(NotifyOneWebThread.class);
                notifyThread.setPushNotificationResponse(new WebFCMResponse(pnr) );
                taskExecutor.execute(notifyThread);
            });
        }
    }

    @Override
    public void notifyMobile(List<PushNotificationResponse> pushNotificationResponses) {
        if (!pushNotificationResponses.isEmpty()) {
            taskExecutor.execute(() -> {
                NotifyMobileThread notifyThread = applicationContext.getBean(NotifyMobileThread.class);
                notifyThread.setPushNotificationResponses(pushNotificationResponses);
                taskExecutor.execute(notifyThread);
            });
        }
    }

    @Override
    public void notifyWeb2(PushNotificationResponses result) {
        if (result!=null) {
            taskExecutor.execute(() -> {
                NotifyWebThread notifyThread = applicationContext.getBean(NotifyWebThread.class);
                notifyThread.setPushNotificationResponses(result);
                taskExecutor.execute(notifyThread);
            });
        }
    }
}
