package br.com.letscode.authenticatems.controller;

import br.com.letscode.authenticatems.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class TokenController {

    private final TokenService tokenService;

    @GetMapping("{cpf}")
    public String authenticate(@PathVariable(name = "cpf") String cpf){
           return tokenService.authenticate(cpf);
    }

    @GetMapping("/token{token}/cpf{cpf}")
    public Boolean checkAuth(@PathVariable(name = "token") String token, @PathVariable(name = "cpf") String cpf){
        return tokenService.checkAuth(token, cpf);
    }

}
