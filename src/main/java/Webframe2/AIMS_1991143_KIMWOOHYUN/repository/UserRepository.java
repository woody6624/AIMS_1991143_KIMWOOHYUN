package Webframe2.AIMS_1991143_KIMWOOHYUN.repository;

import Webframe2.AIMS_1991143_KIMWOOHYUN.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//Spring data jpa를 활용 @Repository를 이용하였습니다.

@Repository
public interface UserRepository extends JpaRepository<UserEntity,String> {
}
