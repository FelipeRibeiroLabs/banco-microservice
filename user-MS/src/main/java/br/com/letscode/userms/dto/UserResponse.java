package br.com.letscode.userms.dto;

import br.com.letscode.userms.model.User;
import lombok.Data;

@Data
public class UserResponse {

    private String cpf;
    private String name;

    public UserResponse(User user) {
        this.cpf = user.getCpf();
        this.name = user.getName();
    }
}