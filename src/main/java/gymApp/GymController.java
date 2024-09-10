package gymApp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GymController {
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("message", "Welcome to the Gym Membership App!");
        return "home";
    }
}
