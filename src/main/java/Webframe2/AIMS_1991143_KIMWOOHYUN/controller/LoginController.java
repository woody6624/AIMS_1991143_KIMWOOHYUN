package Webframe2.AIMS_1991143_KIMWOOHYUN.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage(){
        return "Login";
    }
}
