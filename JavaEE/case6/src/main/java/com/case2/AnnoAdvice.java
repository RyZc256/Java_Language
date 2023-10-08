package com.case2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class AnnoAdvice {

    @Pointcut("execution( * com.case1.UserDaoImpl.*(..))")
    public void poincut(){}

    @Before("poincut()")
    public void before(JoinPoint joinPoint){
        System.out.println("这是前置通知！");
        System.out.println("目标类是"+ joinPoint.getTarget());
        System.out.println(",被织入增强处理的目标方法为："+joinPoint.getSignature().getName());
    }

    @AfterReturning("poincut()")
    public void afterReturning(JoinPoint joinPoint){
        System.out.println("这是返回通知！");
        System.out.println(",被织入增强处理的目标方法为："+joinPoint.getSignature().getName());
    }

    @Around("poincut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("这是环绕通知之前的部分！");
        Object obj= point.proceed();
        System.out.println("这是环绕通知之后的部分！");
        return obj;
    }

    @AfterThrowing("poincut()")
    public void afterException(){
        System.out.println("异常通知！");
    }

    @After("poincut()")
    public void after(){
        System.out.println("这是后置通知！");
    }
}
