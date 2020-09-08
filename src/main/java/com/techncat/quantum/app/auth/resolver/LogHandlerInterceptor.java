package com.techncat.quantum.app.auth.resolver;

import com.techncat.quantum.app.service.log.LogHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LogHandlerInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private LogHelper logHelper;

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        if (handler instanceof HandlerMethod) {
            String sid = String.valueOf(request.getAttribute("$qgfwerhgjrewughjksid"));
            String uri = request.getRequestURI();
            String method = request.getMethod();
            String query = request.getQueryString();

            logHelper.info(sid, method, uri, query);
        }
    }
}
