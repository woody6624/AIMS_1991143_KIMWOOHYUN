package Webframe2.AIMS_1991143_KIMWOOHYUN.service;

import Webframe2.AIMS_1991143_KIMWOOHYUN.dto.UserCheckDTO;
import Webframe2.AIMS_1991143_KIMWOOHYUN.entity.AuthoritiesEntity;
import Webframe2.AIMS_1991143_KIMWOOHYUN.entity.UserEntity;
import Webframe2.AIMS_1991143_KIMWOOHYUN.repository.AuthoritiesRepository;
import Webframe2.AIMS_1991143_KIMWOOHYUN.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserCheckService implements UserDetailsService {
    private final UserRepository userRepository;
    private final AuthoritiesRepository authoritiesRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserCheckService(UserRepository userRepository, AuthoritiesRepository authoritiesRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authoritiesRepository = authoritiesRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> userEntity = userRepository.findById(username);
        Optional<AuthoritiesEntity> authoritiesEntity = authoritiesRepository.findById(username);

        if (userEntity.isPresent() && authoritiesEntity.isPresent()) {
            //Optional타입으로 받아주기 떄문에 존재하는지 isPresent로 확인해주어야합니다.
            // 사용자의 비밀번호를 BCrypt로 해싱하여 저장 insert문을 통하여서 mysql쪽에 저장하였기 떄문에 mysql에서 받아올떄 
            //passwordEncoder를 통하여서 BCrypt로 해싱을 처리하고 받아줘야합니다.그렇지 않는다면 스프링 시큐리티에서 로그인 중 에러가 발생합니다.
            String hashedPassword = passwordEncoder.encode(userEntity.get().getPassword());
            return new UserCheckDTO(userEntity.get().getUserName(), authoritiesEntity.get().getAuthority(), hashedPassword);
        } else {
            return null;
        }
    }
}
