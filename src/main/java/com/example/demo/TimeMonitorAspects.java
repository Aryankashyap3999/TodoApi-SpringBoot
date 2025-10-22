package com.example.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect // it tells all the logic is written here.
@Component // it enables spring boot to read it.
public class TimeMonitorAspects {

    @Around("@annotation(TimeMonitor)") // it says that logTime will get executed when @TimeMonitor is attached to a class.
    public void logTime(ProceedingJoinPoint joinPoint) {
        long start = System.currentTimeMillis();

        try {
            joinPoint.proceed();
        } catch (Throwable e) {
            System.out.println("Something went wrong during execution");
        } finally {
            long end = System.currentTimeMillis();

            long executionTime = end - start;

            System.out.println("Total execution of the method is: " + executionTime + "ms..");
        }

    }
}
