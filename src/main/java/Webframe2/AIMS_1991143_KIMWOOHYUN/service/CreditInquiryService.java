package Webframe2.AIMS_1991143_KIMWOOHYUN.service;

import Webframe2.AIMS_1991143_KIMWOOHYUN.dto.SendYearSemesterDTO;
import Webframe2.AIMS_1991143_KIMWOOHYUN.entity.CourseEntity;
import Webframe2.AIMS_1991143_KIMWOOHYUN.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
@Service
public class CreditInquiryService {//학년별 이수 학점 조회
    private final CourseRepository courseRepository;
    public List<SendYearSemesterDTO> SendYearSemesterDTOs=new ArrayList<>();
    @Autowired
    public CreditInquiryService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    
    public List<SendYearSemesterDTO> sendCreditInquiry(){//학년별 이수 학점 조회
        SendYearSemesterDTOs.clear(); // 리스트 초기화->해당 페이지를 리로드할 시에 모든 리스트를 비워주어야합니다.

        //각각 년도와 학기에 대해서 List<CourseEntity>를 선언해주고 해당 데이터들을 받아옵니다.
        List<CourseEntity> courseEntity_2019_1= courseRepository.getCourseByYearAndSemester(2019,1);
        List<CourseEntity> courseEntity_2019_2= courseRepository.getCourseByYearAndSemester(2019,2);
        List<CourseEntity> courseEntity_2022_1= courseRepository.getCourseByYearAndSemester(2022,1);
        List<CourseEntity> courseEntity_2022_2= courseRepository.getCourseByYearAndSemester(2022,2);
        List<CourseEntity> courseEntity_2023_1= courseRepository.getCourseByYearAndSemester(2023,1);
        List<CourseEntity> courseEntity_2023_2= courseRepository.getCourseByYearAndSemester(2023,2);
        int sum_2019_1=0;
        int sum_2019_2=0;
        int sum_2022_1=0;
        int sum_2022_2=0;
        int sum_2023_1=0;
        int sum_2023_2=0;
        int sum_all=0;
        //각각의 학년 학기에 대해서 SendYearSemesterDTO를 생성하고  SendYearSemesterDTOs리스트에 add해줍니다.
        //단 SendYearSemesterDTO의 마지막 변수creditAllSum는 총 학점이므로 sum_all에 
        //지속적으로 더해가다 2023년 2학기에 해당하는 sendYearSemesterDTO6에만  sendYearSemesterDTO6.setCreditAllSum(sum_all);
        //을 해줍니다.
        for(int i=0; i<courseEntity_2019_1.size(); i++){
            sum_2019_1+=courseEntity_2019_1.get(i).getCredit();
        }
        SendYearSemesterDTO sendYearSemesterDTO1=new SendYearSemesterDTO();
        sendYearSemesterDTO1.setYear(courseEntity_2019_1.get(0).getYear());
        sendYearSemesterDTO1.setSemester(courseEntity_2019_1.get(0).getSemester());
        sendYearSemesterDTO1.setCreditSum(sum_2019_1);
        sum_all+=sum_2019_1;

        for(int i=0; i<courseEntity_2019_2.size(); i++){
            sum_2019_2+=courseEntity_2019_2.get(i).getCredit();
        }
        SendYearSemesterDTO sendYearSemesterDTO2=new SendYearSemesterDTO();
        sendYearSemesterDTO2.setYear(courseEntity_2019_2.get(0).getYear());
        sendYearSemesterDTO2.setSemester(courseEntity_2019_2.get(0).getSemester());
        sendYearSemesterDTO2.setCreditSum(sum_2019_2);
        sum_all+=sum_2019_2;


        for(int i=0; i<courseEntity_2022_1.size(); i++){
            sum_2022_1+=courseEntity_2022_1.get(i).getCredit();
        }
        SendYearSemesterDTO sendYearSemesterDTO3=new SendYearSemesterDTO();
        sendYearSemesterDTO3.setYear(courseEntity_2022_1.get(0).getYear());
        sendYearSemesterDTO3.setSemester(courseEntity_2022_1.get(0).getSemester());
        sendYearSemesterDTO3.setCreditSum(sum_2022_1);
        sum_all+=sum_2022_1;

        for(int i=0; i<courseEntity_2022_2.size(); i++){
            sum_2022_2+=courseEntity_2022_2.get(i).getCredit();
        }
        SendYearSemesterDTO sendYearSemesterDTO4=new SendYearSemesterDTO();
        sendYearSemesterDTO4.setYear(courseEntity_2022_2.get(0).getYear());
        sendYearSemesterDTO4.setSemester(courseEntity_2022_2.get(0).getSemester());
        sendYearSemesterDTO4.setCreditSum(sum_2022_2);
        sum_all+=sum_2022_2;


        for(int i=0; i<courseEntity_2023_1.size(); i++){
            sum_2023_1+=courseEntity_2023_1.get(i).getCredit();
        }
        SendYearSemesterDTO sendYearSemesterDTO5=new SendYearSemesterDTO();
        sendYearSemesterDTO5.setYear(courseEntity_2023_1.get(0).getYear());
        sendYearSemesterDTO5.setSemester(courseEntity_2023_1.get(0).getSemester());
        sendYearSemesterDTO5.setCreditSum(sum_2023_1);
        sum_all+=sum_2023_1;


        for(int i=0; i<courseEntity_2023_2.size(); i++){
            sum_2023_2+=courseEntity_2023_2.get(i).getCredit();
        }
        SendYearSemesterDTO sendYearSemesterDTO6=new SendYearSemesterDTO();
        sendYearSemesterDTO6.setYear(courseEntity_2023_2.get(0).getYear());
        sendYearSemesterDTO6.setSemester(courseEntity_2023_2.get(0).getSemester());
        sendYearSemesterDTO6.setCreditSum(sum_2023_2);
        sum_all+=sum_2023_2;
        sendYearSemesterDTO6.setCreditAllSum(sum_all);
        SendYearSemesterDTOs.add(sendYearSemesterDTO1);
        SendYearSemesterDTOs.add(sendYearSemesterDTO2);
        SendYearSemesterDTOs.add(sendYearSemesterDTO3);
        SendYearSemesterDTOs.add(sendYearSemesterDTO4);
        SendYearSemesterDTOs.add(sendYearSemesterDTO5);
        SendYearSemesterDTOs.add(sendYearSemesterDTO6);



        return SendYearSemesterDTOs;
    }
    public List<CourseEntity> getCreditInquiry(int year, int semester){//학년별 이수 학점 조회
        List<CourseEntity> courseEntity= courseRepository.getCourseByYearAndSemester(year,semester);
        return courseEntity;
    }

    public void create_2024_myCourse(String courseCode,String courseName,String courseType,String professor,int credit) {
        //수강 신청시에 해당 내용을 데이터 베이스쪽에 저장해줍니다.
        CourseEntity courseEntity=new CourseEntity();
        courseEntity.setYear(2024);
        courseEntity.setSemester(2);
        courseEntity.setCourseCode(courseCode);
        courseEntity.setCourseName(courseName);
        courseEntity.setCourseType(courseType);
        courseEntity.setProfessor(professor);
        courseEntity.setCredit(credit);
        //데이터베이스에 해당 엔티티 정보를 저장해줍니다.
        courseRepository.save(courseEntity);

    }
}
