package ken.blog.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    @Column(nullable = false, length = 50)
    private String postTitle;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String postContent;

    @CreationTimestamp
    @Column(updatable = false)
    private Date postCreateDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    //연관관계 메서드
    public void setUser(User user) {
        this.user = user;
        user.getPosts().add(this);
    }
}
