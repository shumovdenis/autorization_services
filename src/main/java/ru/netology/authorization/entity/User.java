package ru.netology.authorization.entity;

import ru.netology.authorization.enums.Authorities;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class User {
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String password;
    private List<Authorities> permissions;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(String name, String password, List<Authorities> permissions) {
        this.name = name;
        this.password = password;
        this.permissions = permissions;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Authorities> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Authorities> permissions) {
        this.permissions = permissions;
    }
}
