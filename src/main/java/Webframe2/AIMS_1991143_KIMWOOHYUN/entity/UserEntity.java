package Webframe2.AIMS_1991143_KIMWOOHYUN.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "user")
@Data
@RequiredArgsConstructor
public class UserEntity {
    @Id
    @Column(name = "username")
    private String userName;

    @Column(name = "email")
    @NotNull
    private String email;

    @Column(name = "password")
    private String password;

}
