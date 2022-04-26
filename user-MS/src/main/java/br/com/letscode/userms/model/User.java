package br.com.letscode.userms.model;

import br.com.letscode.userms.dto.UserRequest;
import br.com.letscode.userms.dto.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String cpf;

    private String password;

    @Column(nullable = false)
    private String name;

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime updateDate;

    public User(UserRequest request, String encryptedPassword) {
        this.cpf = request.getCpf();
        this.name = request.getName();
        this.password = encryptedPassword;
    }

    public User(UserResponse userResponse) {
        this.cpf = userResponse.getCpf();
        this.name = userResponse.getName();
    }
}