package com.example.demo.services;


import java.util.List;

import com.example.demo.model.Greeting;
import com.example.demo.model.User;


public interface IGreetingService {

	Greeting greetingMessage();


	Greeting addGreeting(User user);


	Greeting findById(long id);


	List<Greeting> getAllMessages();

	Greeting updateMessage(long id);


	void deleteMessage(long id);
	

	



	

	
	
	


}
