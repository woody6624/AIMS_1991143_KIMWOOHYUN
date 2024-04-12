package Webframe2.AIMS_1991143_KIMWOOHYUN.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;
//DB에서 user테이블에 해당하는 엔티티입니다.
@Entity
@Table(name = "user")
@Data
@RequiredArgsConstructor
public class UserEntity {
    @Id
    @Column(name = "username")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

}
