package ru.diasoft.msa.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@Aspect
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("@annotation(LogArguments)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceed = joinPoint.proceed();

        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        Map<String, String[]> parameterMap = sra.getRequest().getParameterMap();
        logger.log(Level.INFO, "Входящие параметры вызова:");
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            logger.log(Level.INFO, "Ключ: " + entry.getKey() + ", значение: " + Arrays.toString(entry.getValue()));
        }
        return proceed;
    }
}
