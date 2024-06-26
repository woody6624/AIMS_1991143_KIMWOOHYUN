package Webframe2.AIMS_1991143_KIMWOOHYUN.repository;

import Webframe2.AIMS_1991143_KIMWOOHYUN.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
//Spring data jpa를 활용 @Repository를 이용하였습니다.
//JPQL을 사용하는 @Query를 이용하여 해당하는 년도와 학기에 대한 답을 주는  getCourseByYearAndSemester를 사용했습니다.
@Repository
public interface CourseRepository extends JpaRepository<CourseEntity,String> {

    @Query("SELECT g FROM CourseEntity g WHERE g.year = :year AND g.semester = :semester")
     List<CourseEntity> getCourseByYearAndSemester(int year,int semester);
}
