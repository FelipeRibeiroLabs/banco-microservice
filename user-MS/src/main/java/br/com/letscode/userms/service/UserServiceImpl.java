package br.com.letscode.userms.service;

import br.com.letscode.userms.dto.UserRequest;
import br.com.letscode.userms.dto.UserResponse;
import br.com.letscode.userms.model.User;
import br.com.letscode.userms.repository.UserRepository;
import br.com.letscode.userms.security.GetAuth;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final GetAuth getAuth;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public String authenticate(String cpf, String password) throws RuntimeException {
        log.info("CPF: {}",cpf);
        User user = userRepository.findByCpf(cpf).orElseThrow(
                () -> new RuntimeException("CPF não cadastrado")
        );

        if(!passwordEncoder.matches(password, user.getPassword())){
            throw new RuntimeException("Senha incorreta");
        }

        return getAuth.authenticate(cpf);
    }

    @Override
    public UserResponse findByCpf(String cpf) {
        User user = userRepository.findByCpf(cpf).orElseThrow(
                () -> new RuntimeException("CPF não cadastrado")
        );
        return new UserResponse(user);
    }

    @Override
    public UserResponse create(UserRequest request) {
        var passwordEncrypted = passwordEncoder.encode(request.getPassword());

        User user =  userRepository.save(new User(request, passwordEncrypted));
        return new UserResponse(user);
    }
}