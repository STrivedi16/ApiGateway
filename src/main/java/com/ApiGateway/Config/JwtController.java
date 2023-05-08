package com.ApiGateway.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ApiGateway.Response.ErrorMessage;
import com.ApiGateway.Response.ErrorMessageConstant;
import com.ApiGateway.Response.ErrorMessageKey;
import com.ApiGateway.Response.SuccessMessage;
import com.ApiGateway.Response.SuccessMessageConstant;
import com.ApiGateway.Response.SuccessMessageKey;
import com.ApiGateway.Response.SucessMessageToken;
import com.ApiGateway.model.JwtRequest;
import com.netflix.discovery.converters.Auto;

@RestController
public class JwtController {

	@Autowired
	private JwtTokenUtils tokenUtils;
	
	@Autowired
	private JwtRefreshToken jwtRefreshToken;
	
	@Autowired
	private CustomerUserDetailsService customerUserDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/login")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest)
	{
		System.out.println(jwtRequest);
		
		
		if(jwtRequest.getUsername().isEmpty() && jwtRequest.getPassword().isEmpty())
		{
			return new ResponseEntity<>(new ErrorMessage(ErrorMessageConstant.INVALID_USERNAME_PASSWORD, ErrorMessageKey.USER_EO311OO),HttpStatus.BAD_REQUEST);
			
		}
		else if(jwtRequest.getUsername().isEmpty()==false && jwtRequest.getPassword().isEmpty()){
			return new ResponseEntity<>(new ErrorMessage(ErrorMessageConstant.INVALID_USERNAME_PASSWORD, ErrorMessageKey.USER_EO311OO),HttpStatus.BAD_REQUEST);
			
		}
		else if(jwtRequest.getUsername().isEmpty() && jwtRequest.getPassword().isEmpty()==false){
			return new ResponseEntity<>(new ErrorMessage(ErrorMessageConstant.INVALID_USERNAME_PASSWORD, ErrorMessageKey.USER_EO311OO),HttpStatus.BAD_REQUEST);
			
		}
		else {
	
		
		try {
			
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
			
			
			
		}
		catch (Exception e) {
			return new ResponseEntity<>(new ErrorMessage(e.getMessage(), ErrorMessageKey.USER_EO311OO),HttpStatus.BAD_REQUEST);
			
		}
		
		}
		UserDetails details=this.customerUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
	
		
		
		String token=this.tokenUtils.generateToken(details);
		
		String reftoken=this.jwtRefreshToken.generateRefToken(details);
		
		return new ResponseEntity<>(new SucessMessageToken(SuccessMessageConstant.USER_LOGIN, SuccessMessageKey.USER_MO311OO, token, reftoken),HttpStatus.OK);
		
		}
}
