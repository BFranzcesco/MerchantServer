package com.fbtm;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    private String registrationID;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@RequestBody String registrationID) {
        this.registrationID = registrationID;
    }

    @RequestMapping("/order")
    public void order() {
        NotificationService service = new NotificationService();
        service.pushNotificationToGCM(registrationID, "One margherita please!");
    }

}