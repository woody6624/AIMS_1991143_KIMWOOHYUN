package Webframe2.AIMS_1991143_KIMWOOHYUN.dto;

import jakarta.persistence.PersistenceContext;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SendYearSemesterDTO {
    private int year;//년도
    private int semester;//학기
    private int creditSum;//학점 총계(해당 년도와 학기에 수강한 과목들의 학점 총합입니다.
    private int creditAllSum;//학점 All 총계(모든 년도와 학기에 수강한 과목들의 총합을 나타내줍니다.)
}
