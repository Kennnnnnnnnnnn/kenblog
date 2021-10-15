package ken.blog.Controller;

import ken.blog.domain.Comment;
import ken.blog.domain.Post;
import ken.blog.domain.User;
import ken.blog.form.CommentForm;
import ken.blog.repository.PostRepository;
import ken.blog.repository.UserRepository;
import ken.blog.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class CommentController {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CommentService commentService;

    @PostMapping("/createComment/{id}")
    public String createComment(@PathVariable Long id, @Valid CommentForm form, Principal principal) {

        Comment comment = new Comment();
        User user = userRepository.findByUsername(principal.getName());
        Post post = postRepository.findById(id).get();

        comment.setCommentContent(form.getCommentContent());
        comment.setUser(user);
        comment.setPost(post);

        commentService.join(comment);

        return "redirect:/{id}";
    }
}
