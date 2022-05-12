package com.community.mapper;

import com.community.dto.QuestionQueryDTO;
import com.community.model.Question;

import java.util.List;

public interface QuestionExtMapper {
    int incView(Question record);

    int incCommentCount(Question record);

    List<Question> selectRelated(Question question);

    Integer countBySearch(QuestionQueryDTO question);

    int incLikeCount(Question dbQuestion);

    void incStarCount(Question dbQuestion);

    List<Question> selectBySearch(QuestionQueryDTO questionQueryDTO);
}