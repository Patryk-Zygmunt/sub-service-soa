package agh.givealift.subs.service.implementation;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.naming.AuthenticationException;

@Service
public class ValidationService {
    private final String url = "http://localhost:8080/api/user/validate";

    public void validateUser(String token) throws AuthenticationException {

        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, token);
        headers.set(HttpHeaders.CONTENT_TYPE, String.valueOf(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        ResponseEntity<Long> res = rest.exchange(url, HttpMethod.GET,entity,Long.class);
        if (res.getStatusCode() != HttpStatus.OK ) {
            throw new AuthenticationException();
        }
    }
}
