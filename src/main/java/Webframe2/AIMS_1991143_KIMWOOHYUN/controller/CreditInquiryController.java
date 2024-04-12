package Webframe2.AIMS_1991143_KIMWOOHYUN.controller;

import Webframe2.AIMS_1991143_KIMWOOHYUN.dto.CourseFormDTO;
import Webframe2.AIMS_1991143_KIMWOOHYUN.dto.SendYearSemesterDTO;
import Webframe2.AIMS_1991143_KIMWOOHYUN.entity.CourseEntity;
import Webframe2.AIMS_1991143_KIMWOOHYUN.service.CreditInquiryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/credit-inquiry")
public class CreditInquiryController {


    private final CreditInquiryService creditInquiryService;


    public CreditInquiryController(CreditInquiryService creditInquiryService) {
        this.creditInquiryService = creditInquiryService;
    }


    @GetMapping("/search")
    public String getAllCourses(Model model) {
        List<SendYearSemesterDTO> sendYearSemesterDTO = creditInquiryService.sendCreditInquiry();
        model.addAttribute("sendYearSemesterDTO", sendYearSemesterDTO);
        model.addAttribute("totalCredit", sendYearSemesterDTO.get(sendYearSemesterDTO.size()-1).getCreditAllSum());

        return "CreditInquiry"; // credit-inquiry.html로 이동
    }


    @GetMapping("/detail")
    public String getCourseDetail(@RequestParam int year, @RequestParam int semester, Model model) {
        List<CourseEntity> courses = creditInquiryService.getCreditInquiry(year, semester);
        model.addAttribute("course", courses);
        return "CreditInquiryDetail"; // credit-inquiry.html로 이동
    }

    @GetMapping("/search/2024-02")  //24년 2학기 수강 신청 내역
    public String get_2024_02_courses(Model model) {
        List<CourseEntity> courses = creditInquiryService.getCreditInquiry(2024,2);
        model.addAttribute("course", courses);
        return "2024_02_CreditInquiry"; // credit-inquiry.html로 이동
    }

    @GetMapping("/go")
    public String gotoInquiryForm(Model model){
        model.addAttribute("courseFormDTO",new CourseFormDTO());
        return "CreditInquiryGo";
    }


    //수강신청하는 컨트롤러
    @PostMapping("/submitGoCreditInquiryForm")
    //유효성 검증을 해줍니다.
    public String inquiryCourse(@Valid  @ModelAttribute CourseFormDTO courseFormDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "CreditInquiryGo"; // 폼 다시 표시
        }
        //유효한 경우
        creditInquiryService.create_2024_myCourse(courseFormDTO.getCourseCode(),courseFormDTO.getCourseName(), courseFormDTO.getCourseType(), courseFormDTO.getProfessor(), courseFormDTO.getCredit());
        return "redirect:/";
    }


}
