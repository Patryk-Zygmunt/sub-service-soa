package agh.givealift.subs.service.threads;

import agh.givealift.subs.configuration.Configuration;
import agh.givealift.subs.model.response.SubscriptionResponse;

import com.google.gson.Gson;
import com.stefanik.cod.controller.COD;
import com.stefanik.cod.controller.CODFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@Scope("prototype")
public class NotifyBotThread extends Thread {

    private static final COD cod = CODFactory.get();
    private List<SubscriptionResponse> subscriptionResponseList;

    public void setSubscriptionResponseList(List<SubscriptionResponse> subscriptionResponseList) {
        this.subscriptionResponseList = subscriptionResponseList;
    }

    @Override
    public void run() {

        try {

            HttpClient httpClient = HttpClientBuilder.create().build();
            StringEntity postingString = new StringEntity(new Gson().toJson(subscriptionResponseList));
            HttpPost post = new HttpPost(Configuration.BOT_NOTIFY_URL);
            post.setEntity(postingString);
            post.setHeader("Content-type", "application/json");
            HttpResponse response = httpClient.execute(post);
            cod.c().i("BOT NOTIFY ", subscriptionResponseList, response.getStatusLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
