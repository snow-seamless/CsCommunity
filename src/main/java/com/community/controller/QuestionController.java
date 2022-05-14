package com.community.controller;

import com.community.dto.CommentDTO;
import com.community.dto.QuestionDTO;
import com.community.dto.ResultDTO;
import com.community.enums.CommentTypeEnum;
import com.community.exception.CustomizeErrorCode;
import com.community.model.User;
import com.community.service.CommentService;
import com.community.service.LikeService;
import com.community.service.QuestionService;
import com.community.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private LikeService likeService;
    @Autowired
    private StarService starService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") Long id,
                           HttpServletRequest request,
                           Model model) {
        User user = (User) request.getSession().getAttribute("user");
        QuestionDTO questionDTO = questionService.getById(id);
        List<QuestionDTO> relatedQuestions = questionService.selectRelated(questionDTO);
        List<CommentDTO> commentDTOList = commentService.listByTargetID(id, CommentTypeEnum.QUESTION.getType());
        if (user == null) {
            model.addAttribute("isLiked", false);
            model.addAttribute("isStared", false);
        } else {
            Boolean isLiked = likeService.checkIsLiked(id, user.getAccountId());
            Boolean isStared = starService.checkIsStared(id, user.getAccountId());
            model.addAttribute("isLiked", isLiked);
            model.addAttribute("isStared", isStared);
        }
        // 累加阅读数
        questionService.incView(id);
        model.addAttribute("question", questionDTO);
        model.addAttribute("comments", commentDTOList);
        model.addAttribute("relatedQuestions", relatedQuestions);
        return "question";
    }

}
