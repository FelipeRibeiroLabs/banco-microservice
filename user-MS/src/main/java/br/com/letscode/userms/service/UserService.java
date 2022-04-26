package br.com.letscode.userms.service;

import br.com.letscode.userms.dto.UserRequest;
import br.com.letscode.userms.dto.UserResponse;

public interface UserService {

    String authenticate(String username, String password) throws RuntimeException;

    UserResponse findByCpf(String cpf);

    UserResponse create(UserRequest request);
}