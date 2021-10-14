package ken.blog.Controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class LoginForm {

    @NotEmpty(message = "name is empty")
    private String username;

    @NotEmpty(message = "password is empty")
    private String password;
}
