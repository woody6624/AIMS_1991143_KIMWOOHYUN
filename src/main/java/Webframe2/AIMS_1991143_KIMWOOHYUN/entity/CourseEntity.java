package Webframe2.AIMS_1991143_KIMWOOHYUN.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name = "course")
@Data
@RequiredArgsConstructor
public class CourseEntity {

    @Column(name = "year")
    private int year;

    @Column(name = "semester")
    private int semester;
    //기본키, 과목 코드
    @Id
    @Column(name = "course_code")
    private String courseCode;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_type")
    private String courseType;

    @Column(name = "professor")
    private String professor;

    @Column(name = "credit")
    private int credit;
}
