package Webframe2.AIMS_1991143_KIMWOOHYUN.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CourseFormDTO {
    @NotEmpty(message="반드시 작성해야됩니다.")
    private String courseCode;

    @NotEmpty(message="반드시 작성해야됩니다.")
    private String courseName;

    @NotEmpty(message="반드시 작성해야됩니다.")
    private String courseType;

    @NotEmpty(message="반드시 작성해야됩니다.")
    private String professor;

    @NotNull(message="반드시 작성해야됩니다.")
    private Integer credit;
}
