package ru.netology.authorization.repository;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.netology.authorization.entity.User;
import ru.netology.authorization.entity.UserArguments;
import ru.netology.authorization.enums.Authorities;

import java.util.ArrayList;
import java.util.List;

@Repository
@Component
@ConfigurationProperties(prefix = "user-list")
public class UserRepository {
    private List<User> users;

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> list = new ArrayList<>();
        for (User u: users) {
            if (u.getName().equals(user) && u.getPassword().equals(password)) {
                list = u.getPermissions();
                return list;
            }
        }
        return list;
    }
}
