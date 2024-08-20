package com.alan.uaa.config;

import com.alan.uaa.dto.UserRoleDTO;
import com.alan.uaa.dto.UserRoleThreadLocal;
import com.alan.uaa.utils.Base64Util;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class UserAspect {

    @Resource
    private HttpServletRequest request;

    @Pointcut("execution(* com.alan.uaa.demos.web.*.*(..))")
    public void userPointcut() {}

    @Before("userPointcut()")
    public void beforeUserAdvice() throws JsonProcessingException {
        String token = request.getHeader("token");
        if (!StringUtils.isEmpty(token)) {
            String userInfo = Base64Util.decoder(token);
            UserRoleDTO userRoleDTO = new ObjectMapper().readValue(userInfo, UserRoleDTO.class);
            UserRoleThreadLocal.setContextHolder(userRoleDTO);
        }
    }

    @After("userPointcut()")
    public void afterUserAdvice(){
        UserRoleThreadLocal.removeContextHolder();
    }
}
