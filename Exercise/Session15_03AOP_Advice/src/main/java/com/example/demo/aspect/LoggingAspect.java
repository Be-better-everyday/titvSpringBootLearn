package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
//    @Before("execution(* com.example.demo.service.CalculatorService.add(..))")
//    public void beforeAdd(JoinPoint joinPoint){
//        System.out.println("Running method ADD Calculator:");
//    }
//
//    @After("execution(* com.example.demo.service.CalculatorService.add(..))")
//    public void afterAdd(JoinPoint joinPoint) throws InterruptedException {
//        System.out.println("After running method ADD Calculator:");
//    }
//
//    @AfterThrowing("execution(* com.example.demo.service.CalculatorService.*(..))")
//    public void afterThrowing(JoinPoint joinPoint) throws InterruptedException {
//    }

    /* *Note* 15.5 */

    @Pointcut("execution(* com.example.demo.service.*.*(..))")
    public void myPointCut(){
        System.out.println("Result: ");
    }

    @After("myPointCut()")
    public void afterCalculateAdd(JoinPoint joinPoint){
        System.out.println("Done: " + joinPoint.getSignature().getName());
    }

    @Before("myPointCut()")
    public void beforeCalculateAdd(JoinPoint joinPoint){
        System.out.println("Running: " + joinPoint.getSignature().getName());
    }

    @Around("myPointCut()")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();

        long executeTime = endTime - startTime;
        System.out.println("result = " + result);
        System.out.println("executeTime = " + executeTime);
        return result;
    }
}
