/**
 * 提交回复
 */
function post() {
    var questionId = $("#question_id").val();
    var content = $("#comment_content").val();
    comment2target(questionId, 1, content);
}

function comment2target(targetId, type, content) {
    if (!content) {
        alert("不能回复空内容！");
        return;
    }
    $.ajax({
        type: "POST", url: "/comment", contentType: 'application/json', data: JSON.stringify({
            "parentId": targetId, "content": content, "type": type
        }), success: function (response) {
            if (response.code == 200) {
                window.location.reload();
            } else {
                if (response.code == 2003) {
                    var isAccepted = confirm(response.message);
                    if (isAccepted) {
                        $('#myModal').modal({});
                        // window.open("https://github.com/login/oauth/authorize?client_id=7f316909bf70d1eaa2b2&redirect_uri=" + document.location.origin + "/callback&scope=user&state=1");
                        // window.localStorage.setItem("closable", true);
                    }
                } else {
                    alert(response.message);
                }
            }
        }, dataType: "json"
    });
}

/**
 * 展开二级评论
 */
function collapseComments(e) {
    var id = e.getAttribute("data-id");
    var comments = $("#comment-" + id);
    // 获取一下二级评论的展开状态
    var collapse = e.getAttribute("data-collapse");
    if (collapse) {
        // 折叠二级评论
        comments.removeClass("in");
        e.removeAttribute("data-collapse");
        e.classList.remove("active");
    } else {
        var subCommentContainer = $("#comment-" + id);
        if (subCommentContainer.children().length != 1) {
            // 展开二级评论
            comments.addClass("in");
            // 标记二级评论展开状态
            e.setAttribute("data-collapse", "in");
            e.classList.add("active");
        } else {
            $.getJSON("/comment/" + id, function (data) {
                $.each(data.data.reverse(), function (index, comment) {
                    var mediaLeftElement = $("<div/>", {
                        "class": "media-left"
                    }).append($("<img/>", {
                        "class": "media-object img-rounded", "src": comment.user.avatarUrl
                    }));

                    var mediaBodyElement = $("<div/>", {
                        "class": "media-body"
                    }).append($("<h5/>", {
                        "class": "media-heading", "html": comment.user.accountName
                    })).append($("<div/>", {
                        "html": comment.content
                    })).append($("<div/>", {
                        "class": "menu"
                    }).append($("<span/>", {
                        "class": "pull-right", "html": moment(comment.gmtCreate).format('YYYY-MM-DD')
                    })));

                    var mediaElement = $("<div/>", {
                        "class": "media"
                    }).append(mediaLeftElement).append(mediaBodyElement);

                    var commentElement = $("<div/>", {
                        "class": "col-lg-12 col-md-12 col-sm-12 col-xs-12 comments"
                    }).append(mediaElement);

                    subCommentContainer.prepend(commentElement);
                });
                // 展开二级评论
                comments.addClass("in");
                // 标记二级评论展开状态
                e.setAttribute("data-collapse", "in");
                e.classList.add("active");
            });
        }
    }
}

/**
 * 提交二级评论
 */
function comment(e) {
    var commentId = e.getAttribute("data-id");
    var content = $("#input-" + commentId).val();
    comment2target(commentId, 2, content);
}

/**
 * 判断输入的tag是否存在
 */
function selectTag(e) {
    var value = e.getAttribute("data-tag");
    var previous = $("#tag").val();

    if (previous) {
        var index = 0;
        var appear = false; // 记录value是否已经作为一个独立的标签出现过
        while (true) {
            index = previous.indexOf(value, index); // value字符串在previous中出现的位置
            if (index == -1) break;
            // 判断previous中出现的value是否是另一个标签的一部分
            // 即value的前一个和后一个字符都是逗号","或者没有字符时，才说明value是一个独立的标签
            if ((index == 0 || previous.charAt(index - 1) == ",") && (index + value.length == previous.length || previous.charAt(index + value.length) == ",")) {
                appear = true;
                break;
            }
            index++; // 用于搜索下一个出现位置
        }
        if (!appear) {
            // 若value没有作为一个独立的标签出现过
            $("#tag").val(previous + ',' + value);
        }
    } else {
        $("#tag").val(value);
    }
}

/**
 * 展示tag
 */
function showSelectTag() {
    $("#select-tag").show();
}

/**
 * 给帖子收藏以及取消收藏
 */
function starIt(e) {
    var stared = e.className.indexOf("stared");
    var iconElement = document.getElementById("starIcon");
    var textElement = document.getElementById("starText");
    var targetID = $("#staredQuestionId").val();
    let cnt = $("#staredCount").val();
    if (stared != -1) {
        // 请求取消收藏接口
        $.ajax({
            type: "POST", url: "/star", contentType: 'application/json', data: JSON.stringify({
                "targetId": targetID, "type": 0,
            }), success: function (response) {
                if (response.code == 200) {
                    // 请求成功
                    // 取消收藏的状态
                    iconElement.classList.remove("glyphicon-star");
                    iconElement.classList.add("glyphicon-star-empty");
                    textElement.innerText = (parseFloat(cnt) - 1).toString();
                } else {
                    alert("取消收藏错误！");
                }

            }, dataType: "json"
        });
    } else {
        // 请求收藏接口
        $.ajax({
            type: "POST", url: "/star", contentType: 'application/json', data: JSON.stringify({
                "targetId": targetID, "type": 1,
            }), success: function (response) {
                if (response.code == 200) {
                    // 请求成功
                    // 加上收藏的状态
                    iconElement.classList.remove("glyphicon-star-empty");
                    iconElement.classList.add("glyphicon-star");
                    textElement.innerText = (parseFloat(cnt) + 1).toString();
                } else {
                    alert("收藏错误！请登录，或者重试！");
                }

            }, dataType: "json"
        });
    }
}

/**
 * 给帖子点赞以及取消点赞
 */
function likeIt(e) {
    var liked = e.className.indexOf("liked");
    var iconElement = document.getElementById("likeIcon");
    var textElement = document.getElementById("likeText");
    var targetID = $("#likedQuestionId").val();
    let cnt = $("#likedCount").val();
    if (liked != -1) {
        // 请求取消点赞接口
        $.ajax({
            type: "POST", url: "/like", contentType: 'application/json', data: JSON.stringify({
                "targetId": targetID, "type": 0,
            }), success: function (response) {
                if (response.code == 200) {
                    // 请求成功
                    // 取消点赞的状态
                    iconElement.classList.remove("glyphicon-heart");
                    iconElement.classList.add("glyphicon-heart-empty");
                    textElement.innerText = (parseFloat(cnt) - 1).toString();
                } else {
                    alert("取消点赞错误！");
                }

            }, dataType: "json"
        });
    } else {
        // 请求点赞接口
        $.ajax({
            type: "POST", url: "/like", contentType: 'application/json', data: JSON.stringify({
                "targetId": targetID, "type": 1,
            }), success: function (response) {
                if (response.code == 200) {
                    // 请求成功
                    // 加上点赞的状态
                    iconElement.classList.remove("glyphicon-heart-empty");
                    iconElement.classList.add("glyphicon-heart");
                    textElement.innerText = (parseFloat(cnt) + 1).toString();
                } else {
                    alert("点赞错误！请登录，或者重试！");
                }

            }, dataType: "json"
        });
    }
}


/**
 * 给回复点赞以及取消点赞
 */
function likeComment(e) {
    var liked = e.className.indexOf("active");
    var targetID = $("#likedCommentId").val();
    let cnt = $("#likedCommentCount").val();
    var textElement = document.getElementById("likeCommentText");
    if (liked != -1) {
        // 请求取消点赞接口
        $.ajax({
            type: "POST", url: "/like", contentType: 'application/json', data: JSON.stringify({
                "targetId": targetID, "type": 2,
            }), success: function (response) {
                if (response.code == 200) {
                    // 请求成功
                    textElement.innerText = (parseFloat(cnt) - 1).toString();
                    e.classList.remove("active");
                } else {
                    alert("取消点赞错误！");
                }
            }, dataType: "json"
        });
    } else {
        // 请求点赞接口
        $.ajax({
            type: "POST", url: "/like", contentType: 'application/json', data: JSON.stringify({
                "targetId": targetID, "type": 3,
            }), success: function (response) {
                if (response.code == 200) {
                    // 请求成功
                    textElement.innerText = (parseFloat(cnt) + 1).toString();
                    e.classList.add("active");
                } else {
                    alert("点赞错误！");
                }
            }, dataType: "json"
        });
    }
}

/**
 *检查评论是否被点赞
 */
function checkLiked() {
    var id = $("#likedCommentId").val();
    if (id == null) return;
    $.getJSON("/isCommentLiked/" + id, function (data) {
        if (data.data == "true") {
            var p = document.getElementById("likeCommentIcon");
            p.classList.add("active");
        }
        window.onload = checkLiked;
    });
}

// 跳转到修改信息界面
function modify() {
    window.location.replace("/modify");
}

function invokeSetTime(obj) {
    let countdown = 60;
    setTime(obj);

    function setTime(obj) {
        if (countdown === 0) {
            $(obj).attr("disabled", false);
            $(obj).text("GetCode");
            countdown = 60;
            return;
        } else {
            $(obj).attr("disabled", true);
            $(obj).text("(" + countdown + ") s resend");
            countdown--;
        }
        setTimeout(function () {
            setTime(obj)
        }, 1000);
    }
}

function sendActiveEmail() {
    var email = $('input[name="email"]').val();
    if (email == null || email.trim().length === 0) {
        alert("请输入邮箱！");
        return;
    }
    $.getJSON("/sendActiveEmail/" + email, function (data) {
        if (data.code === 200) {
            invokeSetTime("#send-email-btn");
        } else {
            alert(data.message);
        }
    });
}

function sendModifyEmail() {
    var email = $('input[id="inputNewEmail"]').val();
    debugger;
    if (email == null || email.trim().length === 0) {
        alert("请输入邮箱！");
        return;
    }
    $.getJSON("/sendModifyEmail/" + email, function (data) {
        if (data.code === 200) {
            invokeSetTime("#send-email-btn");
        } else {
            alert(data.message);
        }
    });
}

function isImage() {
    let filePath = $('input[name="avatarPath"]').val();
    let fileFormat = filePath.substring(filePath.lastIndexOf(".")).toLowerCase();
    if (!fileFormat.match(/.png|.jpg|.jpeg/)) {
        alert("请上传图片！");
        return false;
    } else {
        return true;
    }
}

function isVisible(e) {
    var status = e.className.indexOf("glyphicon-eye-close");
    var oldPwd = document.getElementById("inputOldPassword");
    var newPwd1 = document.getElementById("inputNewPassword1");
    var newPwd2 = document.getElementById("inputNewPassword2");
    if (status != -1) {
        // 密码不可见
        e.classList.remove("glyphicon-eye-close");
        e.classList.add("glyphicon-eye-open");
        oldPwd.type = "text";
        newPwd1.type = "text";
        newPwd2.type = "text";
    } else {
        // 密码可见
        e.classList.remove("glyphicon-eye-open");
        e.classList.add("glyphicon-eye-close");
        oldPwd.type = "password";
        newPwd1.type = "password";
        newPwd2.type = "password";
    }
}

function isSame() {
    var newPwd1 = $('input[id="inputNewPassword1"]').val();
    var newPwd2 = $('input[id="inputNewPassword2"]').val();
    if (newPwd1 == newPwd2 && newPwd1 != "" && newPwd2 != "") return true; else return false;
}


// 修改密码
function modifyPassword() {
    var userId = $("#userId").val();
    var oldPwd = $("#inputOldPassword").val();
    var newPwd1 = $('input[id="inputNewPassword1"]').val();
    var newPwd2 = $('input[id="inputNewPassword2"]').val();
    var param = {};
    param['newPassword'] = $('input[id="inputNewPassword1"]').val();
    if (oldPwd == "") {
        alert("旧密码不能为空，请重新输入！");
    }
    $.getJSON("/checkPassword/" + userId + "/" + oldPwd, function (data) {
        if (data.code === 200) {
            if (newPwd1 == "" || newPwd2 == "") {
                alert("新密码不能为空，请重新输入！");
            }
            // 密码校验成功
            if (isSame()) {
                // 两次输入的密码一致，请求修改密码
                $.ajax({
                    type: "POST",
                    url: "/modifySecurity/password",
                    data: param,
                    success: function (response) {
                        if (response.code == 200) {
                            // 请求成功
                            window.location.reload();
                            alert("密码修改成功！");
                        } else {
                            alert("密码修改失败！");
                        }
                    },
                    dataType: "json"
                });
            } else {
                // 两次输入的密码不一致
                alert("两次输入的密码不一致，请重新输入！");
            }
        } else {
            // 密码校验失败
            alert("当前密码错误，请重新输入！");
        }
    });
}

// 修改邮箱
function modifyEmailFunc() {
    // var userId = $("#userId").val();
    var param = {};
    param['newEmail'] = $('input[id="inputNewEmail"]').val();
    $.ajax({
        type: "POST",
        url: "/modifySecurity/email",
        data: param,
        success: function (response) {
            if (response.code == 200) {
                // 请求成功
                window.location.reload();
                alert("邮箱修改成功！");
            } else {
                alert("邮箱修改失败！");
            }
        },
        dataType: "json"
    });
}