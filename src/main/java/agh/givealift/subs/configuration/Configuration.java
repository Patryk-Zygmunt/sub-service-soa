package agh.givealift.subs.configuration;

import java.util.Arrays;
import java.util.List;

public class Configuration {
    public static final Integer SEARCH_BEFORE_SEC = 0;
    public static final Integer SEARCH_AFTER_SEC = 24 * 60 * 60;
    public static final Integer SEARCH_INTERCHANGE_AFTER_SEC = 2 * 60 * 60;
    public static final long HOURS_DIFFERENCE = 0;
    public static final String BOT_NOTIFY_URL = "https://givealift-bot.herokuapp.com/notify";
    //    public static final String BOT_NOTIFY_URL = "http://localhost:8080/api/route/testBot";
    public static final String WEB_NOTIFY_URL = "https://fcm.googleapis.com/fcm/send";
//    public static final String WEB_NOTIFY_URL = "https://mysterious-lowlands-82501.herokuapp.com/api/route/testWeb";
    public static final String MOBILE_NOTIFY_URL = "https://fcm.googleapis.com/fcm/send";
//    public static final String MOBILE_NOTIFY_URL = "https://mysterious-lowlands-82501.herokuapp.com/api/route/testMobile";

//    public static final int BOT_NOTIFY_TIMEOUT_SEC = 5;

    public static final String DATE_SEARCH_PATTERN = "yyyy-MM-dd";
    public static final String DATA_PATTERN = "yyyy-MM-dd HH:mm";

  
}
