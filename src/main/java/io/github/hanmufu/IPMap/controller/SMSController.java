package io.github.hanmufu.IPMap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.github.hanmufu.IPMap.service.SMSService;

import java.util.*;

@RestController
@RequestMapping(value = "/SMS")
public class SMSController {

    @Autowired
    private SMSService smsService;

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String sendSMS(@RequestBody Map<String, Object> params) {
        String phoneNumber = params.get("phoneNumber").toString();
        String message = params.get("message").toString();
        String areaCode = params.get("areaCode").toString();
        return smsService.sendSMS(phoneNumber, message, areaCode);
    }

}
