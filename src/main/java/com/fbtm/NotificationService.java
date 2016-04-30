package com.fbtm;

import com.google.android.gcm.server.InvalidRequestException;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Service
public class NotificationService {

    public static final String API_KEY = "AIzaSyBTAhRyGXTybFEwt0SVV8_N5qKdzhdudfA";

    public boolean pushNotificationToGCM(String registrationID, String message){
        final int retries = 3;
        Sender sender = new Sender(API_KEY);
        Message msg = new Message.Builder().addData("message",message).build();

        try {
            if(registrationID!=null) {
                Result result = sender.send(msg, registrationID, retries);
                /**
                 * if you want to send to multiple then use below method
                 * send(Message message, List<String> regIds, int retries)
                 **/

                if (StringUtils.isEmpty(result.getErrorCodeName())) {
                    System.out.println("GCM Notification is sent successfully" + result.toString());
                    return true;
                }

                System.out.println("Error occurred while sending push notification :" + result.getErrorCodeName());

            }
        } catch (InvalidRequestException e) {
            System.out.println("Invalid Request");
        } catch (IOException e) {
            System.out.println("IO Exception");
        }
        return false;

    }

}
