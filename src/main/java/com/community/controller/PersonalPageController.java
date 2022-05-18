package com.community.controller;

import com.community.dto.PaginationDTO;
import com.community.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PersonalPageController {
    @GetMapping("/personalPage/{action}")
    public String profile(@PathVariable(name = "action") String action,
                          Model model,
                          HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/";
        }
        if ("info".equals(action)) {
            model.addAttribute("section", "info");

        } else if ("security".equals(action)) {
            model.addAttribute("section", "security");

        }
        return "personalPage";
    }
}
