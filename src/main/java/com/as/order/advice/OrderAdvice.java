package com.as.order.advice;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import com.as.order.domain.Order;

@Aspect
public class OrderAdvice {
	
	private Logger logger = Logger.getLogger(OrderAdvice.class);
	
	@Around("execution(* com.as.order.services.*.newOrder(..))")
	public Object timeTakenByNewOrder(ProceedingJoinPoint method) throws Throwable{
		String msgPrefix = "Total time for ";
		String msg;
		
		//Start the stopwatch
		long startTime = System.nanoTime();
		
		//run the taget code
		Object returnValue = method.proceed();
		
		//Stop the watch
		long stopTime = System.nanoTime();
		long totalTime = stopTime-startTime;
		
		double seconds = (double) totalTime/1000000000;
		
		msg = msgPrefix + method.getSignature() + ":" + seconds + " seconds.";
		logger.debug(msg);
		
		return returnValue;
	}
	
	@Around("execution(public double com.as.order.services.*.computeTax(..))")
	public Object computeTaxAdvice(ProceedingJoinPoint method) throws Throwable{
		
		Object methodArgs[] = method.getArgs();
		Order order = null;
		for(Object methodArg : methodArgs){
			order = (Order) methodArg;
		}
		
		if(order.getCustomer().getState().equals("CA")){
			Object returnValue =  method.proceed();
			logger.debug( "Taget method "+ method.getSignature() + "Return Value: "+ returnValue);
			return returnValue;
		}else{
			Object returnValue = method.proceed();
			return returnValue;
		}
	}
	
	

}
