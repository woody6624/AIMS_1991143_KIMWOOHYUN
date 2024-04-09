package Webframe2.AIMS_1991143_KIMWOOHYUN.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {
    //로그아웃은 Get방식으로 처리합니다.
    //세션을 날리는 식으로 로그인한 사용자의 정보를 날리어서 로그아웃을 시킨 후 redirect:"리다이렉트할 경로"
    //현재 경로는 "/" 으로 설정하였습니다.
    @GetMapping("/logout")
    public String userLogout(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/";
    }
}
