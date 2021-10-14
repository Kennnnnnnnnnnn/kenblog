package ken.blog.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class SecurityUser extends org.springframework.security.core.userdetails.User {
    private static final String ROLE_PREFIX = "ROLE_";
    private static final long serialVersionUID = 1L;

    public SecurityUser(ken.blog.domain.User user) {
        super(user.getUsername(), user.getPassword(), makeGrantedAuthority(user.getRoles()));
    }

    private static List<GrantedAuthority> makeGrantedAuthority(List<UserRole> roles) {
        List<GrantedAuthority> list = new ArrayList<>();
        roles.forEach(role -> list.add(new SimpleGrantedAuthority(ROLE_PREFIX + role.getRoleName())));
        return list;
    }
}
