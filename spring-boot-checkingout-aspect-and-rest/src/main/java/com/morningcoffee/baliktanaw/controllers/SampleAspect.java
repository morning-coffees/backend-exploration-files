package com.morningcoffee.baliktanaw.controllers;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SampleAspect {
	
	@Before(value = "execution(* com.morningcoffee.baliktanaw.controllers.BookController.*(..))")
	public void log() {
		System.out.println("Called!!!!");
	}
	

}
