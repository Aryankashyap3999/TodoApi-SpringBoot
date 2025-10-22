package com.example.demo;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // where should this annotation is applicable
@Retention(RetentionPolicy.RUNTIME) // what should be retention policy like runtime so it is retained at time of runtime.

public @interface TimeMonitor {

}
