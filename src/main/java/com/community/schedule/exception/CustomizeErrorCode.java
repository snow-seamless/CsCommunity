package com.community.schedule.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode {
    QUESTION_NOT_FOUND(2001, "你找的问题不存在了，要不要换一个试试？"),
    TARGET_PARAM_NOT_FOUND(2002, "未选择任何评论和问题进行恢复！"),
    NOT_LOGIN(2003, "未登录不能进行评论，请登录！"),
    SYSTEM_ERROR(2004, "服务器冒烟了，请稍后再试！"),
    TYPE_PARAM_WRONG(2005, "评论类型错误或不存在！"),
    COMMENT_NOT_FOUND(2006, "回复的评论不存在！"),
    CONTENT_IS_EMPTY(2007, "输入内容不能为空!"),
    READ_NOTIFICATION_FAIL(2008, "不能读取他人的消息！"),
    NOTIFICATION_NOT_FOUND(2009, "消息似乎不见了..."),
    FILE_UPLOAD_FAIL(2010, "图片上传失败"),
    INVALID_INPUT(2011, "非法输入"),
    INVALID_OPERATION(2012, "操作错误！"),
    USER_DISABLE(2013, "操作被禁用，如有疑问请联系管理员"),
    RATE_LIMIT(2014, "操作太快了，请稍后重试！"),
    IS_NOT_LEGAL(2015, "操作不合法！");

    private String message;
    private Integer code;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }

}
