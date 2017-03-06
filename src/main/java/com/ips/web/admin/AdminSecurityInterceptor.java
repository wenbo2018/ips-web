package com.ips.web.admin;

import com.ips.dto.ApiData;
import com.ips.services.api.ApiDataService;
import com.ips.services.api.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by shenwenbo on 2017/2/16.
 */
public class AdminSecurityInterceptor implements HandlerInterceptor {



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();



        String user = (String) session.getAttribute("Global.USER_SESSION_KEY");
        if(!StringUtils.isEmpty(user)) {
            request.getSession(true).setAttribute("user", user);
            return true;

        }
        response.sendRedirect("/sso/login");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }


}
