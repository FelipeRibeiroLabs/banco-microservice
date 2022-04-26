package br.com.letscode.authenticatems.service;

import br.com.letscode.authenticatems.model.Token;
import br.com.letscode.authenticatems.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final TokenRepository tokenRepository;

    public String authenticate(String cpf){

        if (tokenRepository.findByCpf(cpf).isPresent()) {
            tokenRepository.delete(tokenRepository.findByCpf(cpf).get());
        }

        Token token = new Token();
        token.setToken(UUID.randomUUID().toString());
        token.setCpf(cpf);
        token.setExpiration(Timestamp.valueOf(LocalDateTime.now().plusMinutes(200)));

        tokenRepository.save(token);

        return token.getToken();
    }

    public boolean checkAuth(String token, String cpf){
        Token tokenAuth = tokenRepository.findByToken(token).orElseThrow(
            () -> new RuntimeException("Token inválido")
        );

        return Objects.equals(tokenAuth.getCpf(), cpf)
                &&
                tokenAuth.getExpiration().toLocalDateTime().isAfter(LocalDateTime.now());
    }
}
