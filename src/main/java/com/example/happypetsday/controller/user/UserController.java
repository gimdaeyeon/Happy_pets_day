package com.example.happypetsday.controller.user;

import com.example.happypetsday.dto.UserDto;
import com.example.happypetsday.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user/*")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //    회원가입 화면 이동
    @GetMapping("/join")
    public String join(Model model) {
        return "user/join";
    }

    //        회원가입 처리
    @PostMapping("/join")
    public RedirectView join(UserDto userDto) {
//    if (!userService.isUserIdAvailable(userDto.getUserId())) {
//        // 아이디가 이미 사용 중인 경우
//        return new RedirectView("/user/checkDuplicate");
//    }
        userService.register(userDto);
        return new RedirectView("/user/login");
    }


    //    로그인 처리
    @PostMapping("/login")
    public RedirectView login(String userId, String userPassword, HttpServletRequest req, RedirectAttributes redirectAttributes) {
        try {
            UserDto user = userService.findUserNumberAndStatus(userId, userPassword);

            switch (user.getUserStatus()) {
//                회원의 상태가 관리자인 경우 관리자번호도 함께 부여
                case 0:
                    req.getSession().setAttribute("adminNumber", user.getUserNumber());
                    break;
//                회원의 상태가 탈퇴 회원인 경우 일단 회원가입 화면으로 이동
                case -1:
                    String msg = "관리자에 의해 제명되었습니다. 이의사항이 있을 경우 관리자 email로 문의하세요.";
                    redirectAttributes.addFlashAttribute("guideMsg", msg);
                    return new RedirectView("/user/join");
            }

            req.getSession().setAttribute("userNumber", user.getUserNumber());

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return new RedirectView("/user/login");
        }

        return new RedirectView("/");
    }

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest req) {
        req.getSession().invalidate(); //세션 초기화
        return "user/login";
    }


    @GetMapping("/findId")
    public String findId() {
        return "user/findId";
    }

    @GetMapping("/findPW")
    public String findPW() {
        return "user/findPW";
    }


}
