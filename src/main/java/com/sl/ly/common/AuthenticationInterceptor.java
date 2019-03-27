package com.sl.ly.common;

import com.auth0.jwt.JWT;
import com.sl.ly.utils.JwtUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class AuthenticationInterceptor implements HandlerInterceptor {
    private static final String TOKEN_NULL = "token_null";


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            System.out.println("我是静态资源");
            return true;
        }
        Method method = ((HandlerMethod) handler).getMethod();
        if (method.isAnnotationPresent(PassToken.class)) {
            System.out.println("我有PassToken注解");
            return true;
        }
        System.out.println("我被拦截了");
        String token = request.getHeader("token");
        System.out.println(token);
        if (token == null) {
            response.setStatus(403);
            return false;
        }
        String userUUID = JWT.decode(token).getClaim("userUUID").asString();
        System.out.println(userUUID);
        try{
            JwtUtils.isVerify(token);
        }catch (Exception e){
            response.setStatus(401);
            return false;
        }
        return false;
    }
}
