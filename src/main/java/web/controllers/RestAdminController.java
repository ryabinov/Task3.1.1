package web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestAdminController {

    @GetMapping("/admin")
    public String getAdminPage() {
        return "admin";
    }

}


