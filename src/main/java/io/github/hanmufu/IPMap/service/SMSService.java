package io.github.hanmufu.IPMap.service;

public interface SMSService {

    String sendSMS(String phoneNumber, String message, String areaCode);

}
