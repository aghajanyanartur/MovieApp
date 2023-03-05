package art.yourmovie.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PeopleController {
    @GetMapping("your-movie")
    public String homePage(){
        return "homepage";
    }

    @GetMapping("login-page")
    public String loginPage(){
        return "loginpage";
    }

    @GetMapping("signup-page")
    public String signupPage(){
        return "signuppage";
    }
}
