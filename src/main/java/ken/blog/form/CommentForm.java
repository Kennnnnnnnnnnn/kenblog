package ken.blog.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class CommentForm {

    @NotEmpty(message = "commentContent is empty")
    private String commentContent;
}
