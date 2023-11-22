package com.example.happypetsday.controller.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class CustomErrorController implements ErrorController {

    @GetMapping("/error")
    public String error(Model model, HttpServletRequest req) {
//        상태코드를 얻기 위한 key는 우리가 외워서 쓸 수 없으므로 RequestDispatcher가 가진 상수를 활용한다.
        Object attribute = req.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (attribute != null) {
            int statusCode = Integer.valueOf(attribute.toString());
            System.out.println("===============");
            log.info(String.valueOf(statusCode));
            System.out.println("===============");
            model.addAttribute("errorCode", statusCode);
            String errorMsg = "";

            switch (statusCode) {
                case 404:
                    errorMsg = "잘못된 url주소입니다.";
                    break;
                case 500:
                    errorMsg = "서버 오류입니다.";
                    break;
                default:
                    errorMsg = "요청 처리 중 오류가 발생하였습니다.";
                    break;
            }
            model.addAttribute("errorMsg",errorMsg);
        }
        return "error/errorPage";
    }


}
