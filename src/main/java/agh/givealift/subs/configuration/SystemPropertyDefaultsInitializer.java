package agh.givealift.subs.configuration;

import com.stefanik.cod.controller.COD;
import com.stefanik.cod.controller.CODFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import java.util.TimeZone;

@Configuration
public class SystemPropertyDefaultsInitializer
        implements WebApplicationInitializer {
    private static final COD cod = CODFactory.get();


    @Override
    public void onStartup(ServletContext servletContext) {
        cod.e("on startup");
        // can be set runtime before Spring instantiates any beans
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+02:00"));
//        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

}
