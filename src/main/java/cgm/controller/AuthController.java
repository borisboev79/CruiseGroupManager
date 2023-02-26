package cgm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/login")
    private String login() {
        return "auth-login";
    }

    @GetMapping("/error")
    private String errorLogin(@RequestParam(required = false) String error, Model model) {

        if(error != null){
            model.addAttribute("error", "Error logging you in!");
        }


        return "auth-login";
    }

    @GetMapping("/logout")
    private String logout() {
        return "index";
    }
}
