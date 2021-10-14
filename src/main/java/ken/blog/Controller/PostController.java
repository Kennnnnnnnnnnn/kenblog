package ken.blog.Controller;

import ken.blog.domain.Post;
import ken.blog.repository.PostRepository;
import ken.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Collections;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final PostRepository postRepository;

    @GetMapping("/")
    public String postList(Model model) {
        List<Post> postList = postRepository.findAll();
        Collections.reverse(postList);
        model.addAttribute("postList", postList);
        return "list";
    }

    @GetMapping("/{id}")
    public String list(@PathVariable Long id, Model model) {
        model.addAttribute("list", postRepository.findById(id).get());
        return "detailList";
    }

    @GetMapping("/createPost")
    public String getPost() {
        return "createPost";
    }

    @PostMapping("/createPost")
    public String postPost(@Valid PostForm form, Principal principal) {

        Post post = new Post();

        post.setPostTitle(form.getPostTitle());
        post.setPostContent(form.getPostContent());
        post.setUsername(principal.getName());

        postService.join(post);

        return "redirect:/";
    }

    @PostMapping("/deletePost/{id}")
    public String deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
        return "redirect:/";
    }
}
