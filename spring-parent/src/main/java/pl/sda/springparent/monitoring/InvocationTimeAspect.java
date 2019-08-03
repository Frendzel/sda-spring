package pl.sda.springparent.monitoring;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

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
    public void logTimeInvocation3() {

    }
}
