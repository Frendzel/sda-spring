package pl.sda.springparent.monitoring;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Arrays;

import static java.time.Duration.between;
import static java.time.Instant.now;

@Component
@Aspect
@Slf4j
public class InvocationTimeAspect {

    @Before("@annotation(pl.sda.springparent.monitoring.CalculateInvocationTime)")
    public void logTimeInvocation1() {
        log.info("Before invocation");
    }

    @After("@annotation(pl.sda.springparent.monitoring.CalculateInvocationTime)")
    public void logTimeInvocation2() {
        log.info("After invocation");
    }
    @Around("@annotation(pl.sda.springparent.monitoring.CalculateInvocationTime)")
    public Object logTimeInvocation3(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //Date start = new Date();
        Instant start = now();
//        System.nanoTime()
        Object proceed = proceedingJoinPoint.proceed();
        StringBuilder builder = new StringBuilder(); //vs StringBuffer
        builder.append(Arrays.toString(proceedingJoinPoint.getArgs()));
        builder.append(proceedingJoinPoint.getSignature());
        builder.append(proceed);
        Thread thread = Thread.currentThread();
        builder.append(thread.getName());
        log.info(builder.toString());
        Instant end = now();
        //Date stop =  new Date();
        //stop.getTime() - start.getTime()
        log.info("Invocation: " + between(start, end).toMillis());
        return proceed;
    }
}
