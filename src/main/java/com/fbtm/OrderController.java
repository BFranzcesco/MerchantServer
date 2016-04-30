package com.fbtm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    private String registrationID;

    @RequestMapping("/order")
    public void getIndex() {
        NotificationService service = new NotificationService();
        service.pushNotificationToGCM(registrationID, "Hello! Pizza ready!");
    }

    @RequestMapping("/register")
    public void register(String registrationID) {
        this.registrationID = registrationID;
    }
}