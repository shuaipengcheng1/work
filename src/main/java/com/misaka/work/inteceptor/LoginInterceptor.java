package com.misaka.work.inteceptor;


import net.sf.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
/*
* 该类用于拦截未登录请求
* */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (request.getSession().getAttribute("username") == null) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            PrintWriter out = null;
            try {
                JSONObject res = new JSONObject();
                res.put("success", false);
                res.put("message", "用户未登录！");
                out = response.getWriter();
                out.append(res.toString());
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                response.sendError(500);
                return false;
            }
        }
        return true;
    }


}
