package art.yourmovie.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonalPageController {

    @GetMapping("logout")
    public String logout() {
        return "homepage";
    }
}
