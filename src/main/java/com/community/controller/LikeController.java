package com.community.controller;

import com.community.dto.LikeDTO;
import com.community.dto.ResultDTO;
import com.community.model.Like;
import com.community.model.User;
import com.community.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LikeController {
    @Autowired
    private LikeService likeService;

    @ResponseBody
    @RequestMapping(value = "/like", method = RequestMethod.POST)
    public Object post(@RequestBody LikeDTO likeDTO,
                       HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        Like like = new Like();
        like.setTargetId(likeDTO.getTargetId());
        like.setGmtCreate(System.currentTimeMillis());
        like.setGmtModified(like.getGmtCreate());
        like.setLikeCreator(user.getAccountId());
        if (likeDTO.getType() == 0)
            likeService.deleteQuestionLike(like);
        else if (likeDTO.getType() == 1)
            likeService.insertQuestionLike(like);
        else if (likeDTO.getType() == 2)
            likeService.deleteCommentLike(like);
        else if (likeDTO.getType() == 3)
            likeService.insertCommentLike(like);
        return ResultDTO.okOf();
    }
}
