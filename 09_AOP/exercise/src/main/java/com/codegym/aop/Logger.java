package com.codegym.aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Logger {

    @AfterThrowing(pointcut = "execution(public * com.codegym.service.BookService.borrowBook(..))",
            throwing = "e")
    public void error(Exception e) {
        System.err.println("Error");
    }

    @AfterThrowing(pointcut = "execution(public * com.codegym.service.BookService.payBook(..))",
            throwing = "e")
    public void error1(Exception e) {
        System.err.println("Error");
    }
}