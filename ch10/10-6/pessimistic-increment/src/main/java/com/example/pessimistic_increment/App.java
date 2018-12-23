package com.example.pessimistic_increment;

import java.util.List;
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
       		int[] ids1 = new int[] {1,2,3};
       		int[] ids2 = new int[] {3,2,1};
       		int[] deltas1 = new int[] {2,2,2};
       		int[] deltas2 = new int[] {-1,-1,-1};
       		MultiIncrementer inc2 = new MultiIncrementer(counterService, ids1, deltas1, 10);
       		MultiIncrementer dec1 = new MultiIncrementer(counterService, ids2, deltas2, 10);
       		executor.execute(inc2);
       		executor.execute(dec1);
       		executor.shutdown();
       		executor.awaitTermination(10, TimeUnit.MINUTES);
    		System.err.println("inc2 - success: " + inc2.getSuccess() + ", failure: " + inc2.getFailure());
    		System.err.println("dec1 - success: " + dec1.getSuccess() + ", failure: " + dec1.getFailure());

       		List<Counter> counters = counterService.getAllCounters();
       		System.err.println("after competition counters: " + counters);
    	
    	}
    }
}
