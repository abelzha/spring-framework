package aspectdemo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class PersonServiceLogAspect {
	@Pointcut("execution(* aspectdemo.Person.*(..))")
	public void Log(){
	}

	@Before("Log()")
	public  void getLogBefore(JoinPoint point){
		System.out.println(point.getSignature().getName()+"-----getLogBefore,params:"+ Arrays.asList(point.getArgs()));
	}

	@AfterReturning(value = "Log()", returning ="result")
	public  void getLogAfter(JoinPoint point, Object result){
		System.out.println(point.getSignature().getName()+"------getLogAfter,result:"+ result);
	}
}
