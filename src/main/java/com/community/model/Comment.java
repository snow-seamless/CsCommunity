package com.community.model;

public class Comment {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.id
     *
     * @mbg.generated Thu May 19 20:00:06 GMT+08:00 2022
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.parent_id
     *
     * @mbg.generated Thu May 19 20:00:06 GMT+08:00 2022
     */
    private Long parentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.comment_type
     *
     * @mbg.generated Thu May 19 20:00:06 GMT+08:00 2022
     */
    private Integer commentType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.gmt_create
     *
     * @mbg.generated Thu May 19 20:00:06 GMT+08:00 2022
     */
    private Long gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.gmt_modified
     *
     * @mbg.generated Thu May 19 20:00:06 GMT+08:00 2022
     */
    private Long gmtModified;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.like_count
     *
     * @mbg.generated Thu May 19 20:00:06 GMT+08:00 2022
     */
    private Long likeCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.content
     *
     * @mbg.generated Thu May 19 20:00:06 GMT+08:00 2022
     */
    private String content;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.commentator
     *
     * @mbg.generated Thu May 19 20:00:06 GMT+08:00 2022
     */
    private String commentator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.comment_count
     *
     * @mbg.generated Thu May 19 20:00:06 GMT+08:00 2022
     */
    private Long commentCount;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.id
     *
     * @return the value of comment.id
     *
     * @mbg.generated Thu May 19 20:00:06 GMT+08:00 2022
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.id
     *
     * @param id the value for comment.id
     *
     * @mbg.generated Thu May 19 20:00:06 GMT+08:00 2022
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.parent_id
     *
     * @return the value of comment.parent_id
     *
     * @mbg.generated Thu May 19 20:00:06 GMT+08:00 2022
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.parent_id
     *
     * @param parentId the value for comment.parent_id
     *
     * @mbg.generated Thu May 19 20:00:06 GMT+08:00 2022
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.comment_type
     *
     * @return the value of comment.comment_type
     *
     * @mbg.generated Thu May 19 20:00:06 GMT+08:00 2022
     */
    public Integer getCommentType() {
        return commentType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.comment_type
     *
     * @param commentType the value for comment.comment_type
     *
     * @mbg.generated Thu May 19 20:00:06 GMT+08:00 2022
     */
    public void setCommentType(Integer commentType) {
        this.commentType = commentType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.gmt_create
     *
     * @return the value of comment.gmt_create
     *
     * @mbg.generated Thu May 19 20:00:06 GMT+08:00 2022
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.gmt_create
     *
     * @param gmtCreate the value for comment.gmt_create
     *
     * @mbg.generated Thu May 19 20:00:06 GMT+08:00 2022
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.gmt_modified
     *
     * @return the value of comment.gmt_modified
     *
     * @mbg.generated Thu May 19 20:00:06 GMT+08:00 2022
     */
    public Long getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.gmt_modified
     *
     * @param gmtModified the value for comment.gmt_modified
     *
     * @mbg.generated Thu May 19 20:00:06 GMT+08:00 2022
     */
    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.like_count
     *
     * @return the value of comment.like_count
     *
     * @mbg.generated Thu May 19 20:00:06 GMT+08:00 2022
     */
    public Long getLikeCount() {
        return likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.like_count
     *
     * @param likeCount the value for comment.like_count
     *
     * @mbg.generated Thu May 19 20:00:06 GMT+08:00 2022
     */
    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.content
     *
     * @return the value of comment.content
     *
     * @mbg.generated Thu May 19 20:00:06 GMT+08:00 2022
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.content
     *
     * @param content the value for comment.content
     *
     * @mbg.generated Thu May 19 20:00:06 GMT+08:00 2022
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.commentator
     *
     * @return the value of comment.commentator
     *
     * @mbg.generated Thu May 19 20:00:06 GMT+08:00 2022
     */
    public String getCommentator() {
        return commentator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.commentator
     *
     * @param commentator the value for comment.commentator
     *
     * @mbg.generated Thu May 19 20:00:06 GMT+08:00 2022
     */
    public void setCommentator(String commentator) {
        this.commentator = commentator == null ? null : commentator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.comment_count
     *
     * @return the value of comment.comment_count
     *
     * @mbg.generated Thu May 19 20:00:06 GMT+08:00 2022
     */
    public Long getCommentCount() {
        return commentCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.comment_count
     *
     * @param commentCount the value for comment.comment_count
     *
     * @mbg.generated Thu May 19 20:00:06 GMT+08:00 2022
     */
    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }
}