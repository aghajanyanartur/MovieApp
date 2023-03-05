package art.yourmovie.controllers;

import art.yourmovie.models.Person;
import art.yourmovie.services.PeopleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final PeopleService peopleService;

    public LoginController(PeopleService peopleService){
        this.peopleService = peopleService;
    }

        @PostMapping("login")
        public String login(@RequestParam("username") String username,
                             @RequestParam("password") String password, Model model){

            if(     username == null || password == null || username.equals("") || password.equals("") ||
                    peopleService.findUserByUsername(username).isEmpty() ||
                    peopleService.findUserByPassword(password).isEmpty()){
                model.addAttribute("errorMessage", "Invalid data. Try again");
                return "loginpage";
            } else{
                Person person = peopleService.findUserByUsername(username).get();
                if(!person.getPassword().equals(password)){
                    model.addAttribute("errorMessage", "Invalid password. Try again");
                    return "loginpage";
                }
                model.addAttribute("person", person);
                return "personalpage";
            }
        }
}
