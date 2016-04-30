package com.fbtm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {
    private String registrationID;

    @RequestMapping(value = "/order")
    public void getIndex() {
        NotificationService service = new NotificationService();
        service.pushNotificationToGCM(registrationID, "Hello! Pizza ready!");
    }

    @RequestMapping(value = "/register")
    public void register(String registrationID) {
        this.registrationID = registrationID;
    }
}