package com.app;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.app.entities.Person;
import com.app.service.PersonService;

@EnableAsync
@SpringBootApplication
public class AsynDemoApplication {
	
	@Autowired
	private PersonService personService;

	public static void main(String[] args) {
		SpringApplication.run(AsynDemoApplication.class, args);
	}

	@Bean("asyncThreadPool")
	public TaskExecutor getAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);
		executor.setMaxPoolSize(3);
		executor.setWaitForTasksToCompleteOnShutdown(false);
		executor.setThreadNamePrefix("AsyncThread-");
		System.out.println("Async Thread Pool Log");
		return executor;
	}
	
	
	@Bean 
	CommandLineRunner getRunner()
	{
		return args->{
			testAsyncMethod();
		};
	}

	private void testAsyncMethod() throws InterruptedException, ExecutionException {

		CompletableFuture<Person> object1= personService.findByemail("lakshman@gmail.com");
		System.out.println("object1 is called....");
		
		CompletableFuture<Person> object2= personService.findByemail("ganesh@gmail.com");
		System.out.println("object2 is called....");
		
		CompletableFuture<Person> object3= personService.findByemail("ram@gmail.com");
		System.out.println("object3 is called....");
		
		CompletableFuture<Person> object4= personService.findByemail("seth@gmail.com");
		System.out.println("object4 is called....");
		
		CompletableFuture.allOf(object1,object2,object3,object4).join();
		
		System.out.println("--> " + object1.get());
		System.out.println("--> " + object2.get());
		System.out.println("--> " + object3.get());
		System.out.println("--> " + object4.get());
		
	}
	
}
