package ken.blog.service;

import ken.blog.domain.Post;
import ken.blog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Long join(Post post) {

        postRepository.save(post);
        return post.getId();
    }
}
