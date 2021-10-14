package ken.blog.service;

import ken.blog.domain.User;
import ken.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Long join(User user) {
        //중복 회원 검사 넣어야 됨
        userRepository.save(user);
        return user.getId();
    }
}
