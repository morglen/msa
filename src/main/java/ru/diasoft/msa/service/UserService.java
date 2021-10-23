package ru.diasoft.msa.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import ru.diasoft.msa.repository.UserRepository;

public class UserService implements UserDetailsService {

    final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }


    @Override
    public UserDetails loadUserByUsername(String userName) {

        return this.repository.findByUserName(userName).get();
    }

}
