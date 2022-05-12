package com.community.controller;

import com.community.dto.ResultDTO;
import com.community.dto.StarDTO;
import com.community.model.Like;
import com.community.model.Star;
import com.community.model.User;
import com.community.service.LikeService;
import com.community.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class StarController {
    @Autowired
    private StarService starService;

    @ResponseBody
    @RequestMapping(value = "/star", method = RequestMethod.POST)
    public Object post(@RequestBody StarDTO starDTO,
                       HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        Star star = new Star();
        star.setTargetId(starDTO.getTargetId());
        star.setGmtCreate(System.currentTimeMillis());
        star.setGmtModified(star.getGmtCreate());
        star.setStarCreator(user.getAccountId());
        if (starDTO.getType() == 0)
            starService.delete(star);
        else
            starService.insert(star);
        return ResultDTO.okOf();
    }
}
