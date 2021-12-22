package com.example.demo.services;


import com.example.demo.model.Greeting;
import com.example.demo.model.User;


public interface IGreetingService {

	Greeting greetingMessage();


	Greeting addGreeting(User user);

	
	
	


}
