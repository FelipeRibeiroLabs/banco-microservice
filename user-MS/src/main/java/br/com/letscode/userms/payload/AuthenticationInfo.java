package br.com.letscode.userms.payload;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class AuthenticationInfo {

    private String username;
    private Boolean isAuth;
    private Timestamp AuthExpiration;
}