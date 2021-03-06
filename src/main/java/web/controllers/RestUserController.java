package web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestUserController {
    @GetMapping("/user")
    public String getUserPage(){
        return "user";
    }

}
