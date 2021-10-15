package ken.blog.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class PostForm {

    @NotEmpty(message = "postTitle is empty")
    private String postTitle;

    @NotEmpty(message = "postContent is empty")
    private String postContent;

    private String id;
}
