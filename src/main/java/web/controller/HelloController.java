package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HelloController {

    @GetMapping("/")
    public String getRoot(){
        return "redirect:/hello";
    }

    @GetMapping("/hello")
    public String getHello(){
        return "/hello/helloVisitor";
    }

    @GetMapping("/notAllowed")
    public String getNotAllowed(){
        return "/hello/notAllowed";
    }

}
