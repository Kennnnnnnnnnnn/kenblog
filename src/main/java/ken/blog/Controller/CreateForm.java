package ken.blog.Controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class CreateForm {

    @NotEmpty(message = "username is empty")
    private String username;

    @NotEmpty(message = "password is empty")
    private String password;

    @NotEmpty(message = "phone is empty")
    private String phone;
}
