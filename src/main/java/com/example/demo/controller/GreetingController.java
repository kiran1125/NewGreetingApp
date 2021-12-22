package com.example.demo.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.UserData;
import com.example.demo.model.Greeting;
import com.example.demo.model.User;
import com.example.demo.services.IGreetingService;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    
    @GetMapping(value={"/","","/home"})
    public Greeting greeting(@RequestParam(value = "name") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
    @Autowired
    private IGreetingService greetingService;
    
    @GetMapping("/service")
    public Greeting greeting() {
    	return greetingService.greetingMessage();
    }
	
    @GetMapping("/post")
    public Greeting greetingMessage(@RequestParam (value = "firstName") String firstName ,@RequestParam (value = "lastName") String lastName) {
    	User user = new User();
    	user.setFirstName(firstName);
    	user.setLastName(lastName);
        return greetingService.addGreeting(user);
    }
    @GetMapping("/get/{id}")
	public Greeting findById(@PathVariable String id) {
		return greetingService.findById(Long.parseLong(id));
	}
    @GetMapping("/getAll")
	public List<Greeting> getAllGreetings(){
		return greetingService.getAllMessages();
	}
    
    @PutMapping("/update/{id}")
	public Greeting updateMessage(@PathVariable String id) {
		return greetingService.updateMessage(Long.parseLong(id));
	}

    
}
