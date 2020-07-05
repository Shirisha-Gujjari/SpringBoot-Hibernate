package com.sagarandcompany.FirstDemo.service;

import com.sagarandcompany.FirstDemo.domain.Employee;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
//    @Around("execution(* com.sagarandcompany.FirstDemo.service.EmployeeService.*(..))")
//    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("Before around Method----------------");
//
//        try {
//            joinPoint.proceed();
//        } finally {
//            //Do Something useful, If you have
//        }
//        System.out.println("After Method----------------");
//
//    }
    @AfterReturning(returning = "object", value = "execution(* com.sagarandcompany.FirstDemo.service.EmployeeService.*(..))")
    public void after(JoinPoint joinPoint, Employee object) {
        System.out.println("After Returning Method----------------" + object.toString());
    }

    @AfterThrowing(throwing = "throwable", value = "execution(* com.sagarandcompany.FirstDemo.service.EmployeeService.*(..))")
    public void after(JoinPoint joinPoint, Throwable throwable) {
        System.out.println("Exception----------------" + throwable.toString());
    }
}
