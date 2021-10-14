package ken.blog.Controller;

import ken.blog.domain.User;
import ken.blog.domain.UserRole;
import ken.blog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Collections;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/loginAccount")
    public String getLogin(Model model, HttpServletRequest req) {
        String referer = req.getHeader("Referer");
        req.getSession().setAttribute("prevPage", referer);
        model.addAttribute("loginForm", new LoginForm());
        return "loginAccount";
    }

    @PostMapping("/loginAccount")
    public String postLogin(BindingResult result) {
        if (result.hasErrors()) {
            return "loginAccount";
        }
        return "redirect:/";
    }

    @GetMapping("/createAccount")
    public String getCreate(Model model) {
        model.addAttribute("createForm", new CreateForm());
        return "createAccount";
    }

    @PostMapping("/createAccount")
    public String postCreate(@Valid CreateForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "createAccount";
        }

        UserRole role = new UserRole();
        User user = new User();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        user.setUsername(form.getUsername());
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        user.setPhone(form.getPhone());
        role.setRoleName("BASIC");
        user.setRoles(Collections.singletonList(role));

        userService.join(user);

        return "redirect:/";
    }

    @GetMapping("/logoutAccount")
    public String getLogout() {
        return "logoutAccount";
    }

    /**
    @PostMapping("/logoutAccount")
    public String postLogout() {
        return "redirect:/";
    }
    */
}
