package kr.co.justforme.global.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GlblController {
    /**
     * 인덱스 페이지
     */
    @GetMapping("/")
    public String turnIndexPage(Model model) {

        model.addAttribute("name", "게스트");

        return "index";
    }
}
