package az.unique.amigossecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TemplatesController {

    @GetMapping("login")
    public String getLogin(){
        return "login";
    }

    @GetMapping("course")
    public String getCourse(){
        return "course";
    }
}
