package com.flrjcx.xypt.common.handler;

import com.flrjcx.xypt.common.annotation.Validation;
import com.flrjcx.xypt.common.exception.ValidationException;
import com.flrjcx.xypt.common.model.param.common.Manager;
import com.flrjcx.xypt.common.model.param.common.Users;
import com.flrjcx.xypt.common.utils.ManagerThreadLocal;
import com.flrjcx.xypt.common.utils.TokenService;
import com.flrjcx.xypt.common.utils.UserThreadLocal;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author malaka
 * 用户登录验证
 */
@Component
public class ValidationInterceptor implements HandlerInterceptor {

    @Resource
    private TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 放行非Controller中的handler
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        // 验证用户
        // 获取带了注解 Validation 的 handler
        Validation annotation = method.getAnnotation(Validation.class);
        // 有，说明需要用户验证
        if (annotation != null) {
            // 获取请求头的token
            String header = request.getHeader(tokenService.getHeader());
            if(request.getRequestURI().startsWith("/xypt/api/backend")) {
                Manager manager = tokenService.getManagerCache(header);
                if (Objects.isNull(manager)) {
                    throw new ValidationException();
                }
                ManagerThreadLocal.put(manager);
            } else {
                Users users = tokenService.getUserCache(header);
                if (Objects.isNull(users)) {
                    throw new ValidationException();
                }
                UserThreadLocal.put(users);
            }
        }
        // 没有，不需要用户验证
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 如果不删除 ThreadLocal 有内存泄露的风险
        UserThreadLocal.remove();
    }
}
