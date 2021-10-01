package ru.netology.authorization.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.netology.authorization.entity.User;
import ru.netology.authorization.entity.UserArguments;
import ru.netology.authorization.enums.Authorities;
import ru.netology.authorization.service.AuthorizationService;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class AuthorizationController {
    final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid @UserArguments User user) {
        return service.getAuthorities(user);
    }
}
