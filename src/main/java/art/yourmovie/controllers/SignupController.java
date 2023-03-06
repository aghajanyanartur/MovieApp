package art.yourmovie.controllers;

import art.yourmovie.services.PeopleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignupController {

    private final PeopleService peopleService;

    public SignupController(PeopleService peopleService){
        this.peopleService = peopleService;
    }

    @PostMapping("signup")
    public String signup(@RequestParam("username") String username,
                         @RequestParam("password") String password, Model model){

        if(peopleService.findUserByUsername(username).isPresent()){
            model.addAttribute("errorMessage", "Username already exists.");
            return "signuppage";
        } else if(username.length() < 2 || !username.matches(".*[a-zA-Z]+.*")) {
            model.addAttribute("errorMessage", "Username must contain at least one letter and have more than one character.");
            return "signuppage";
        } else if(password.length() < 4) {
            model.addAttribute("errorMessage", "Password must have at least 4 symbols.");
            return "signuppage";
        }
        peopleService.addUser(username, password);
        return "homepage";
    }
}
