package com.alan.uaa.config;

import com.alan.uaa.dto.ResultDTO;
import com.alan.uaa.dto.UserRoleDTO;
import com.alan.uaa.dto.UserRoleThreadLocal;
import com.alan.uaa.utils.Base64Util;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Aspect
@Component
public class UserAspect {

    @Resource
    private HttpServletRequest request;

    @Pointcut("execution(* com.alan.uaa.demos.web.*.*(..))")
    public void userPointcut() {}

    @Around("userPointcut()")
    public Object AroundUserAdvice(ProceedingJoinPoint joinPoint) throws JsonProcessingException {
        String token = request.getHeader("token");
        if (!StringUtils.isEmpty(token)) {
            String userInfo = Base64Util.decoder(token);
            UserRoleDTO userRoleDTO = new ObjectMapper().readValue(userInfo, UserRoleDTO.class);
            UserRoleThreadLocal.setContextHolder(userRoleDTO);
        }

        if(Objects.isNull(UserRoleThreadLocal.getContextHolder()) ||
                Objects.isNull(UserRoleThreadLocal.getContextHolder().getUserId()) ||
                Objects.isNull(UserRoleThreadLocal.getContextHolder().getRole())){
            return ResultDTO.noAuth();
        }

        try {
            return joinPoint.proceed();
        } catch (Throwable ex){
            return ResultDTO.error(ex.getMessage());
        } finally {
            UserRoleThreadLocal.removeContextHolder();
        }

    }
}
