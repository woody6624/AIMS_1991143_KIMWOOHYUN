package Webframe2.AIMS_1991143_KIMWOOHYUN.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;
//DB에서 authorities테이블에 해당하는 엔티티입니다.

@Entity
@Table(name = "authorities")
@Data
@RequiredArgsConstructor
public class AuthoritiesEntity {//스프링 시큐리티의 인증을 위한 테이블

    //기본키 유저이름
    @Id
    @Column(name = "username")
    private String userName;

    
    //인증 권한
    @Column(name = "authority")
    private String authority;
}

