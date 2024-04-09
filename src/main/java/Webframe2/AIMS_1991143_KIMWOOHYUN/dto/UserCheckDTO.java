package Webframe2.AIMS_1991143_KIMWOOHYUN.dto;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
public class UserCheckDTO implements UserDetails {

    private String username; //유저 이름
    private String authority; //인가 권한

    private String password;//비밀번호
    public UserCheckDTO(String username,String authority,String password){
        this.username=username;
        this.authority=authority;
        this.password=password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { //권한을 리턴해줍니다.
        Collection<GrantedAuthority> collection=new ArrayList<>();
        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return authority;
            }
        });

        return collection;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
