package com.community.service;

import com.community.schedule.exception.CustomizeErrorCode;
import com.community.schedule.exception.CustomizeException;
import com.community.mapper.*;
import com.community.model.Comment;
import com.community.model.Like;
import com.community.model.LikeExample;
import com.community.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private LikeMapper likeMapper;
    @Autowired
    private QuestionExtMapper questionExtMapper;
    @Autowired
    private CommentExtMapper commentExtMapper;
    @Autowired
    private CommentMapper commentMapper;

    public void insertQuestionLike(Like like) {
        Question dbQuestion = questionMapper.selectByPrimaryKey(like.getTargetId());
        if (dbQuestion == null) {
            throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
        }
        LikeExample likeExample = new LikeExample();
        likeExample.createCriteria()
                .andTargetIdEqualTo(like.getTargetId())
                .andLikeCreatorEqualTo(like.getLikeCreator());
        List<Like> dbLike = likeMapper.selectByExample(likeExample);
        if (dbLike.size() == 0) {
            // 插入新的点赞记录
            likeMapper.insertSelective(like);
            dbQuestion.setLikeCount(1L);
            questionExtMapper.incLikeCount(dbQuestion);
        } else return;
    }

    public void deleteQuestionLike(Like like) {
        Question dbQuestion = questionMapper.selectByPrimaryKey(like.getTargetId());
        if (dbQuestion == null) {
            throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
        }
        LikeExample likeExample = new LikeExample();
        likeExample.createCriteria()
                .andTargetIdEqualTo(like.getTargetId())
                .andLikeCreatorEqualTo(like.getLikeCreator());
        List<Like> dbLike = likeMapper.selectByExample(likeExample);
        if (dbLike.size() != 0) {
            // 删除该点赞记录
            likeMapper.deleteByPrimaryKey(dbLike.get(0).getId());
            dbQuestion.setLikeCount(-1L);
            questionExtMapper.incLikeCount(dbQuestion);
        } else return;
    }

    public Boolean checkIsLiked(Long id, String accountId) {
        // 查询该条点赞是否存在
        LikeExample likeExample = new LikeExample();
        likeExample.createCriteria()
                .andTargetIdEqualTo(id)
                .andLikeCreatorEqualTo(accountId);
        List<Like> dbLike = likeMapper.selectByExample(likeExample);
        if (dbLike.size() != 0)
            return true;
        else
            return false;
    }

    public void deleteCommentLike(Like like) {
        Comment dbComment = commentMapper.selectByPrimaryKey(like.getTargetId());
        if (dbComment == null) {
            throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
        }
        LikeExample likeExample = new LikeExample();
        likeExample.createCriteria()
                .andTargetIdEqualTo(like.getTargetId())
                .andLikeCreatorEqualTo(like.getLikeCreator());
        List<Like> dbLike = likeMapper.selectByExample(likeExample);
        if (dbLike.size() != 0) {
            // 删除该点赞记录
            likeMapper.deleteByPrimaryKey(dbLike.get(0).getId());
            dbComment.setLikeCount(-1L);
            commentExtMapper.incLikeCount(dbComment);
        } else return;
    }

    public void insertCommentLike(Like like) {
        Comment dbComment = commentMapper.selectByPrimaryKey(like.getTargetId());
        if (dbComment == null) {
            throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
        }
        LikeExample likeExample = new LikeExample();
        likeExample.createCriteria()
                .andTargetIdEqualTo(like.getTargetId())
                .andLikeCreatorEqualTo(like.getLikeCreator());
        List<Like> dbLike = likeMapper.selectByExample(likeExample);
        if (dbLike.size() == 0) {
            // 插入新的点赞记录
            likeMapper.insertSelective(like);
            dbComment.setLikeCount(1L);
            commentExtMapper.incLikeCount(dbComment);
        } else return;
    }

    public Boolean checkCommentIsLiked(Long id, String accountId) {
        // 查询该条点赞是否存在
        LikeExample likeExample = new LikeExample();
        likeExample.createCriteria()
                .andTargetIdEqualTo(id)
                .andLikeCreatorEqualTo(accountId);
        List<Like> dbLike = likeMapper.selectByExample(likeExample);
        if (dbLike.size() != 0)
            return true;
        else
            return false;
    }
}
