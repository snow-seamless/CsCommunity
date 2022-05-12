package com.community.service;

import com.community.exception.CustomizeErrorCode;
import com.community.exception.CustomizeException;
import com.community.mapper.QuestionExtMapper;
import com.community.mapper.QuestionMapper;
import com.community.mapper.StarMapper;
import com.community.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private StarMapper starMapper;
    @Autowired
    private QuestionExtMapper questionExtMapper;

    public void insert(Star star) {
        Question dbQuestion = questionMapper.selectByPrimaryKey(star.getTargetId());
        if (dbQuestion == null) {
            throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
        }
        StarExample starExample = new StarExample();
        starExample.createCriteria()
                .andTargetIdEqualTo(star.getTargetId())
                .andStarCreatorEqualTo(star.getStarCreator());
        List<Star> dbStar = starMapper.selectByExample(starExample);
        if (dbStar.size() == 0) {
            // 插入新的收藏记录
            starMapper.insertSelective(star);
            dbQuestion.setStarCount(1L);
            questionExtMapper.incStarCount(dbQuestion);
        } else return;
    }

    public void delete(Star star) {
        Question dbQuestion = questionMapper.selectByPrimaryKey(star.getTargetId());
        if (dbQuestion == null) {
            throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
        }
        StarExample starExample = new StarExample();
        starExample.createCriteria()
                .andTargetIdEqualTo(star.getTargetId())
                .andStarCreatorEqualTo(star.getStarCreator());
        List<Star> dbStar = starMapper.selectByExample(starExample);
        if (dbStar.size() != 0) {
            // 删除该点赞记录
            starMapper.deleteByPrimaryKey(dbStar.get(0).getId());
            dbQuestion.setStarCount(-1L);
            questionExtMapper.incStarCount(dbQuestion);
        } else return;
    }

    public Boolean checkIsStared(Long id, String accountId) {
        // 查询该条收藏是否存在
        StarExample starExample = new StarExample();
        starExample.createCriteria()
                .andTargetIdEqualTo(id)
                .andStarCreatorEqualTo(accountId);
        List<Star> dbStar = starMapper.selectByExample(starExample);
        if (dbStar.size() != 0)
            return true;
        else
            return false;
    }
}
