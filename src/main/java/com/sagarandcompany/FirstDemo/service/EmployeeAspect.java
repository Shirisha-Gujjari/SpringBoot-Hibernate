package com.sagarandcompany.FirstDemo.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeAspect {
//    @Pointcut("execution(* com.sagarandcompany.FirstDemo.service.EmployeeService.*(..))")
//    public void test() {
//    }

//    @Before("execution(* com.sagarandcompany.FirstDemo.service.EmployeeService.*(..))")
//    public void beforeLogging(JoinPoint joinPoint) {
//        System.out.println("Callin Before Method----------------" + joinPoint.getTarget());
//    }

    //    @After("execution(* com.sagarandcompany.FirstDemo.service.EmployeeService.*(..))")
//    public void after(JoinPoint joinPoint) {
//        System.out.println("After Method----------------" + joinPoint.getTarget());
//    }
    @Around("execution(* com.sagarandcompany.FirstDemo.service.EmployeeService.*(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Before around Method----------------");

        try {
            joinPoint.proceed();
        } finally {
            //Do Something useful, If you have
        }
        System.out.println("After Method----------------");

    }
}
