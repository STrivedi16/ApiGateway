package com.ApiGateway.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

	@GetMapping("/userServiceFallBack")
	public String userServiceFallback() {
		return "User Service Down at this time !!!......";
	}
	
	@GetMapping("/profileServiceFallBack")
	public String contectServiceFallback() {
		return "profile  Service Down at this time !!!......";
	}
}
