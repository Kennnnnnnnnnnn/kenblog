package ken.blog.service;

import ken.blog.domain.Comment;
import ken.blog.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public Long join(Comment comment) {

        commentRepository.save(comment);
        return comment.getId();
    }
}
