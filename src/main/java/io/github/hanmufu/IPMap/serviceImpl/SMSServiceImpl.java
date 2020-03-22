package io.github.hanmufu.IPMap.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import io.github.hanmufu.IPMap.service.SMSService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.*;

@Service
public class SMSServiceImpl implements SMSService {

    public String sendSMS(String phoneNumber, String message, String areaCode) {
        JSONObject responseData = new JSONObject();
        if(areaCode.equals("+1") && phoneNumber.length() != 10) {
            responseData.put("alert", "phone number should be 10 digits");
            return responseData.toJSONString();
        }else if(areaCode.equals("+86") && phoneNumber.length() != 11) {
            responseData.put("alert", "phone number should be 11 digits");
            return responseData.toJSONString();
        }
        Pattern pattern = Pattern.compile("[0-9]*");
        if(!pattern.matcher(phoneNumber).matches()) {
            responseData.put("alert", "not a phone number");
            return responseData.toJSONString();
        }
        BasicAWSCredentials awsCreds = new BasicAWSCredentials("", "");
        AmazonSNSClient snsClient = new AmazonSNSClient(awsCreds);
        message = "From Mufu Han: " + message;
        phoneNumber = areaCode + phoneNumber;
        System.out.println("text message is: " + message);
        System.out.println("target phone number is: " + phoneNumber);
        Map<String, MessageAttributeValue> smsAttributes = new HashMap<String, MessageAttributeValue>();
        smsAttributes.put("AWS.SNS.SMS.SenderID", new MessageAttributeValue()
                .withStringValue("MufuHan") //The sender ID shown on the device.
                .withDataType("String"));
        smsAttributes.put("AWS.SNS.SMS.MaxPrice", new MessageAttributeValue()
                .withStringValue("0.5") //Sets the max price
                .withDataType("Number"));
        smsAttributes.put("AWS.SNS.SMS.SMSType", new MessageAttributeValue()
                .withStringValue("Promotional") //Sets the type to promotional.
                .withDataType("String"));
        sendSMSMessage(snsClient, message, phoneNumber, smsAttributes);
        responseData.put("alert", "Sent successfully");
        return responseData.toJSONString();
    }

    public static void sendSMSMessage(AmazonSNSClient snsClient, String message,
                                      String phoneNumber, Map<String, MessageAttributeValue> smsAttributes) {
        PublishResult result = snsClient.publish(new PublishRequest()
                .withMessage(message)
                .withPhoneNumber(phoneNumber)
                .withMessageAttributes(smsAttributes));
        System.out.println("text sent, message ID: " + result); // Prints the message ID.
    }
}
