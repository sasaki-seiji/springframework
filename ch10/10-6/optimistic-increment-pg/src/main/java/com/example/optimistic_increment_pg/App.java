package com.example.optimistic_increment_pg;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.JpaConfig;
import com.example.domain.model.Counter;
import com.example.domain.repository.CounterService;

public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
    	try(ConfigurableApplicationContext context 
       			= new AnnotationConfigApplicationContext(JpaConfig.class)) {
       		CounterService counterService = context.getBean("counterService", CounterService.class);

       		// competition
       		ExecutorService executor = Executors.newFixedThreadPool(2);
       		Incrementer inc2 = new Incrementer(counterService, 2, 2, 100);
       		Incrementer dec1 = new Incrementer(counterService, 2, -1, 100);
       		executor.execute(inc2);
       		executor.execute(dec1);
       		executor.shutdown();
       		executor.awaitTermination(10, TimeUnit.MINUTES);
    		System.err.println("inc2 - success: " + inc2.getSuccess() + ", failure: " + inc2.getFailure());
    		System.err.println("dec1 - success: " + dec1.getSuccess() + ", failure: " + dec1.getFailure());

       		Counter counter = counterService.getCounter(2);
       		System.err.println("after competition counter(2): " + counter);
    	
    	}
    }
}
