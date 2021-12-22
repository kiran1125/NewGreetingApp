package com.example.demo.services;

import java.util.concurrent.atomic.AtomicLong;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.data.UserData;
import com.example.demo.model.Greeting;
import com.example.demo.model.User;

@Service
public class GreetingService implements IGreetingService {
	private static final String template = "Hello world";
	private final AtomicLong counter = new AtomicLong();

	@Override
	public Greeting greetingMessage() {
		return new Greeting(counter.incrementAndGet(), String.format(template));
	}

	@Override
	public String greetingMessageByName(UserData userData) {
		User user = new User();
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.map(userData, user);
		return ("Hello " + user.getFirstName() + " " + user.getLastName());
	}

	
}
