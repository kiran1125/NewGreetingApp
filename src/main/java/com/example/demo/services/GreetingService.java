package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.UserData;
import com.example.demo.model.Greeting;
import com.example.demo.model.User;
import com.example.demo.repository.GreetingRepository;

@Service
public class GreetingService implements IGreetingService {
	private static final String template = "Hello world";
	private final AtomicLong counter = new AtomicLong();
	
	@Autowired
	private GreetingRepository greetingRepository;

	@Override
	public Greeting greetingMessage() {
		return new Greeting(counter.incrementAndGet(), String.format(template));
	}

	@Override
	public Greeting addGreeting(User user) {
		String message = String.format("Hello " + user.getFirstName() + " " + user.getLastName());
		return greetingRepository.save(new Greeting(counter.incrementAndGet(),message));
	}

	@Override
	public Greeting findById(long id) {		
		return greetingRepository.findById(id).get();
	}

	@Override
	public List<Greeting> getAllMessages() {
		return greetingRepository.findAll();
	}

	@Override
	public Greeting updateMessage(long id) {
		String message = "Hello Kiran Its updated message";
		return greetingRepository.save(new Greeting(id, message));
	}

	@Override
	public void deleteMessage(long id) {
		greetingRepository.deleteById(id);
		
	}

	

	
}
