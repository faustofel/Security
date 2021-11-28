package web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.User;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("")
    public String getHello(@AuthenticationPrincipal User user, Model model){
        model.addAttribute("user", user);
        return "/user/helloUser";
    }
    @GetMapping("/userProfile")
    public String getProfile(){
        //надо бы создать @Entity профайл юзера связать его OneToOne с юзером и сюда выводить его данные ...
        return "/user/userProfile";
    }
}
