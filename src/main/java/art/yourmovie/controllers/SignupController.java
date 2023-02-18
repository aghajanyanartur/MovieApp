package art.yourmovie.controllers;

import art.yourmovie.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class SignupController {

    private final PeopleService peopleService;

    public SignupController(PeopleService peopleService){
        this.peopleService = peopleService;
    }

    @PostMapping("/signup")
    public String signup(@RequestParam("username") String username,
                         @RequestParam("password") String password){

        peopleService.addUser(username, password);

        return "homepage";
    }
}
