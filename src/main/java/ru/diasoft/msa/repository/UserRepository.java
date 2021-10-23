package ru.diasoft.msa.repository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import ru.diasoft.msa.domain.Role;
import ru.diasoft.msa.domain.User;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    private final List<User> userList = Arrays.asList(
            new User("guest", new BCryptPasswordEncoder().encode("guest"), Collections.singletonList(Role.GUEST), true, true, true, true),
            new User("user", new BCryptPasswordEncoder().encode("user"), Collections.singletonList(Role.USER), true, true, true, true),
            new User("admin", new BCryptPasswordEncoder().encode("admin"), Collections.singletonList(Role.ADMIN), true, true, true, true)
    );

    public Optional<User> findByUserName(String userName) {
        return userList.stream()
                .filter(user -> user.getUsername().equals(userName))
                .findFirst();
    }

}
