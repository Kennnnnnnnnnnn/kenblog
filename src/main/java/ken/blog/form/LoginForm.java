package ken.blog.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class LoginForm {

    @NotEmpty(message = "username is empty")
    private String username;

    @NotEmpty(message = "password is empty")
    private String password;
}
