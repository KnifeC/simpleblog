package moe.keshane.simpleblog.component;

import moe.keshane.simpleblog.common.SessionKey;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PermissionIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object user_id = session.getAttribute(SessionKey.USER_ID);
        Object user_name = session.getAttribute(SessionKey.USER_NAME);
        Object user_type = session.getAttribute(SessionKey.USER_TYPE);
        if (user_id == null || user_name == null) {
            request.setAttribute("msg", "请先登录");
            response.sendRedirect("/login");
            return false;
        }
        if (request.getRequestURI().equals("/admin")||request.getRequestURI().equals("/image")||request.getRequestURI().equals("/edit") || request.getRequestURI().equals("/write") || request.getRequestURI().equals("/edit/**") || request.getRequestURI().equals("/deletearticle/**")||request.getRequestURI().equals("/deletecomment/**")) {
            if (user_type.toString().equals("admin")) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
