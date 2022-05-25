package com.community.interceptor;

import com.community.mapper.UserMapper;
import com.community.model.User;
import com.community.model.UserExample;
import com.community.service.NavService;
import com.community.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class SessionInterceptor implements HandlerInterceptor {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private NavService navService;

    @Value("${github.redirect.uri}")
    private String githubRedirectUri;

    @Value("${gitee.redirect.uri}")
    private String giteeRedirectUri;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        //设置 context 级别的属性
        request.getServletContext().setAttribute("giteeRedirectUri", giteeRedirectUri);
        request.getServletContext().setAttribute("githubRedirectUri", githubRedirectUri);

        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0)
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    UserExample userExample = new UserExample();
                    userExample.createCriteria()
                            .andTokenEqualTo(token);
                    List<User> userList = userMapper.selectByExample(userExample);
                    if (userList.size() != 0) {
                        HttpSession session = request.getSession();
                        session.setAttribute("user", userList.get(0));
                        Long unreadCount = notificationService.unreadCount(userList.get(0).getAccountId());
                        session.setAttribute("unreadCount", unreadCount);
                        session.setAttribute("navs", navService.list());
                    }
                    break;
                }
            }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
