package com.chang.oo.singleton;

import java.util.*;
import java.util.concurrent.*;


import java.sql.Connection;
import java.util.Date;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.apache.log4j.Logger;


public class ThreadPoolFactory   {
    private static Logger log = Logger.getLogger(ThreadPoolFactory.class);
	//-------- Class Constructor ----------------
    private static ThreadPoolFactory instance;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(5);
    static {
    	instance = new ThreadPoolFactory();  
    }
    //--- constructor ------
    public ThreadPoolFactory() {
    	threadPool = Executors.newFixedThreadPool(5);
    }
    
    public static ThreadPoolFactory getInstance() {
      return instance;
    }
    public ExecutorService getThreadPool() {
        return threadPool;
      }
    
}    // end of class