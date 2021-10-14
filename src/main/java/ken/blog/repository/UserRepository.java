package ken.blog.repository;

import ken.blog.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final EntityManager em;

    public void save(User user) {
        em.persist(user);
    }

    public User findByUsername(String name) {
        return em.createQuery("select m from User m where m.username = :name", User.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}