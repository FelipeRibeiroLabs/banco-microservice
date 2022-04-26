package br.com.letscode.userms.controller;

import br.com.letscode.userms.dto.LoginRequest;
import br.com.letscode.userms.dto.UserRequest;
import br.com.letscode.userms.dto.UserResponse;
import br.com.letscode.userms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping()
    public UserResponse getUserByCpf(@RequestParam String cpf) {
        return userService.findByCpf(cpf);
    }

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest request) {
        return userService.create(request);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return userService.authenticate(request.getCpf(), request.getPassword());
    }
}
