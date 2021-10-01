package ru.netology.authorization.service;

import org.springframework.stereotype.Service;
import ru.netology.authorization.entity.User;
import ru.netology.authorization.repository.UserRepository;
import ru.netology.authorization.enums.Authorities;
import ru.netology.authorization.exceptions.InvalidCredentials;
import ru.netology.authorization.exceptions.UnauthorizedUser;

import java.util.List;

@Service
public class AuthorizationService {
    final UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User user) {
        String username = user.getName();
        String password = user.getPassword();
        if (isEmpty(username) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(username, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user.getName());
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }


}
