package agh.givealift.subs.controller;

import agh.givealift.subs.model.request.PushNotificationRequest;
import agh.givealift.subs.service.PushNotificationService;
import com.stefanik.cod.controller.COD;
import com.stefanik.cod.controller.CODFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

@CrossOrigin
@Controller
@RequestMapping("/api/notification")
public class PushNotificationController {
    private static final COD cod = CODFactory.get();
    private final PushNotificationService pushNotificationService;

    @Autowired
    public PushNotificationController(PushNotificationService pushNotificationService) {
        this.pushNotificationService = pushNotificationService;
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Long> add(@RequestBody PushNotificationRequest pushNotificationRequest, UriComponentsBuilder ucBuilder) {

        return pushNotificationService.add(pushNotificationRequest)
                .map(
                        s -> {
                            HttpHeaders headers = new HttpHeaders();
                            headers.setLocation(ucBuilder.path("/api/notification/{id}").buildAndExpand(s.getPushNotificationId()).toUri());
                            return ResponseEntity.ok().headers(headers).body(s.getPushNotificationId());
                        }
                )
                .orElse(new ResponseEntity<>(HttpStatus.ALREADY_REPORTED));
    }
}
