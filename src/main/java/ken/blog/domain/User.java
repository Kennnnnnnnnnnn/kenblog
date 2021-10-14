package ken.blog.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@ToString
public class User {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    // 유저 이름 (로그인 아이디)
    @Column(name="username", nullable = false, unique = true, length = 50)
    private String username;

    // 유저 패스워드
    @Column(nullable = false, length = 200)
    private String password;

    // 유저 전화번호
    @Column(nullable = false, length = 20)
    private String phone;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="username")
    private List<UserRole> roles;

    @OneToMany(mappedBy = "user")
    private List<Post> posts = new ArrayList<>();
}
