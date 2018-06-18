package agh.givealift.subs.controller;

import agh.givealift.subs.model.request.PushNotificationRequest;
import agh.givealift.subs.service.PushNotificationService;
import agh.givealift.subs.service.implementation.ValidationService;
import com.stefanik.cod.controller.COD;
import com.stefanik.cod.controller.CODFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.naming.AuthenticationException;

@CrossOrigin
@Controller
@RequestMapping("/api/notification")
public class PushNotificationController {
    private static final COD cod = CODFactory.get();
    private final PushNotificationService pushNotificationService;
    private ValidationService validationService;

    @Autowired
    public PushNotificationController(PushNotificationService pushNotificationService, ValidationService validationService) {
        this.pushNotificationService = pushNotificationService;
        this.validationService = validationService;
    }





    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Long> add(@RequestBody PushNotificationRequest pushNotificationRequest, UriComponentsBuilder ucBuilder, @RequestHeader HttpHeaders header
    ) throws AuthenticationException {
        if(header.get("Authorization")==null)
            throw new AuthenticationException();
        validationService.validateUser(header.get("Authorization").get(0));
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
