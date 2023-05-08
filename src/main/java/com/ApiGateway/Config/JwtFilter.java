package com.ApiGateway.Config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtFilter extends OncePerRequestFilter {

	@Autowired
	private JwtTokenUtils tokenUtils;
	
	@Autowired
	private JwtRefreshToken  refreshToken;
	
	@Autowired
	private CustomerUserDetailsService service;
	
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
	
		String requestHeader=request.getHeader("Authorization");
		
		String jwtToken;
		
		String username = null;
		String type = null;
		
		if(requestHeader!=null && requestHeader.startsWith("Bearer "))
		{
			jwtToken=requestHeader.split(" ")[1].trim();
			
			try {
				
				type=this.tokenUtils.getTypeFromToken(jwtToken);
				
				if(type.equals("Access"))
				{
					username=this.tokenUtils.getUsernameFromToken(jwtToken);
					
				}
				else {
					System.out.println("Error");
				}
			}
			catch (Exception e) {
				new ResponseEntity<>("Invalid Token",HttpStatus.UNAUTHORIZED);
			}
		}
		
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null && type.equals("Access"))
		{
		
			UserDetails details=this.service.loadUserByUsername(username);
			
			UsernamePasswordAuthenticationToken upat=new UsernamePasswordAuthenticationToken(details,null, details.getAuthorities());
			
			upat.setDetails(new WebAuthenticationDetailsSource());
			
			SecurityContextHolder.getContext().setAuthentication(upat);
		}
		else {
			System.out.println("User not valid ");
		}
		
		filterChain.doFilter(request, response);
		
	}

}
