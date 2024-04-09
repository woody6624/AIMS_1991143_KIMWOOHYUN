package Webframe2.AIMS_1991143_KIMWOOHYUN.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")

public class HomeController {


    @GetMapping("/")
    public String mainHomepage(){
        return "MainPage";
    }

}
