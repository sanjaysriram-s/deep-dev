package org.sanorg.deepdev.testcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testy {

    @RequestMapping("/ada_poda")
    public String test() {
        return "Hello World";
    }
    @RequestMapping("/ada_poda2")
    public String test2() {
        return "Hello World2";
    }
    @RequestMapping("/ada_poda3")
    public String test3() {
        return "Hello World3";
    }



}
