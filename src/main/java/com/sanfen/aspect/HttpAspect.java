package com.sanfen.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @Author SanFen
 * @Email sanfenruxi1@163.com
 * @Date 2017/8/1
 * @Version 1.0
 */

@Aspect
@Component
public class HttpAspect {

    @Before("execution(public * com.sanfen.controller.GirlController.*(..))")
    public void log(){
        System.out.println("111111111");
    }

}
