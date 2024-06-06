package hgcq.appleshop.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppleShopController {

    @GetMapping("/")
    public String home() {
        return "main";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/cart")
    public String cart(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);

        if (session != null) {
            // 카트 불러오기 로직
            return "cart";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/myPage")
    public String myPage(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);

        if (session != null) {
            // 자기 정보 불러오는 로직
            return "myPage";
        } else {
            return "myPage";
//            return "redirect:/login";
        }
    }
}
