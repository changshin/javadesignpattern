package com.chang.oodp.creational.singleton;

import java.lang.reflect.Constructor;

/*
 * When you run the above test class, 
 * you will notice that hashCode of both the instances are not same that destroys the singleton pattern. 
 * Reflection is very powerful and used in a lot of frameworks like Spring and Hibernate, 
 * do check out Java Reflection Tutorial.
 */

public class ReflectionSingletonTest {
	 
    public static void main(String[] args) {
        EagerInitializedSingleton instanceOne = EagerInitializedSingleton.getInstance();
        EagerInitializedSingleton instanceTwo = null;
        try {
            Constructor[] constructors = EagerInitializedSingleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                //Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (EagerInitializedSingleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }
 
}