package andrzej.cieslik.ac.end_project;

import andrzej.cieslik.ac.end_project.user.User;
import andrzej.cieslik.ac.end_project.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/test")
    @ResponseBody
    public String adminTest() {
        return "admin/login";
    }

    @GetMapping("/login")
    public String login(Model model, @RequestParam(required=false) Boolean error) {
        if (error != null) {
            model.addAttribute("error", error);
        }
        return "admin/login";
    }

    @GetMapping("/create-user")
    @ResponseBody
    public String createUser() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        userService.saveUser(user);
        return "admin";
    }
}
