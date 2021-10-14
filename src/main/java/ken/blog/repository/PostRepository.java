package ken.blog.repository;

import ken.blog.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Override
    List<Post> findAll();

    @Override
    Optional<Post> findById(Long aLong);

    @Override
    void deleteById(Long aLong);
}