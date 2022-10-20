package com.flrjcx.xypt.common.handler;

import com.alibaba.fastjson.JSON;
import com.flrjcx.xypt.common.annotation.UserValidation;
import com.flrjcx.xypt.common.enums.ResultCodeEnum;
import com.flrjcx.xypt.common.exception.UserValidationException;
import com.flrjcx.xypt.common.model.param.common.UserVo;
import com.flrjcx.xypt.common.model.result.ResponseData;
import com.flrjcx.xypt.common.utils.TokenService;
import com.flrjcx.xypt.common.utils.UserThreadLocal;
import jdk.nashorn.internal.parser.Token;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
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
public class UserValidationInterceptor implements HandlerInterceptor {

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
        // 获取带了注解 UserValidation 的 handler
        UserValidation userAnnotation = method.getAnnotation(UserValidation.class);
        // 有，说明需要用户验证
        if (userAnnotation != null) {
            // 获取请求头的token
            String header = request.getHeader(tokenService.getHeader());
            UserVo userVo = tokenService.getUserCache(header);
            if (Objects.isNull(userVo)) {
                throw new UserValidationException();
            }
            UserThreadLocal.put(userVo);
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
