package Webframe2.AIMS_1991143_KIMWOOHYUN.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
//DB에서 course테이블에 해당하는 엔티티입니다.

@Entity
@Table(name = "course")
@Data
@RequiredArgsConstructor
public class CourseEntity {
    //년도
    @Column(name = "year")
    private int year;
    //학기
    @Column(name = "semester")
    private int semester;
    //기본키, 과목 코드
    @Id
    @Column(name = "course_code")
    private String courseCode;
    //교과목명
    @Column(name = "course_name")
    private String courseName;
    //교과구분
    @Column(name = "course_type")
    private String courseType;
    //담당교수
    @Column(name = "professor")
    private String professor;
    //학점
    @Column(name = "credit")
    private int credit;
}
