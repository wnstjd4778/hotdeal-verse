package com.example.hotdealverse.common.aop;

import com.example.hotdealverse.common.exception.CustomException;
import com.example.hotdealverse.common.exception.ErrorCode;
import com.example.hotdealverse.common.security.jwt.UserPrincipal;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthenticationAop {

    @Around("@annotation(Authenticated)")
    public Object check(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || auth.getPrincipal().getClass() != UserPrincipal.class) {
            throw new CustomException(ErrorCode.JWT_INVALID);
        }
        return proceedingJoinPoint.proceed();
    }

}
