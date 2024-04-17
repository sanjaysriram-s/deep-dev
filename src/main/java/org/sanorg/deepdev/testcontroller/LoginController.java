package org.sanorg.deepdev.testcontroller;

import org.sanorg.deepdev.entity.UserInfo;
import org.sanorg.deepdev.service.testyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/dev")
public class LoginController {

    @Autowired
    private testyService service;

    @RequestMapping("/adduser")
    public String addNewUser(@RequestBody UserInfo userInfo) {
        return service.addUser(userInfo);
    }


}
