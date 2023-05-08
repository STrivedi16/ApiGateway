package com.ApiGateway.Config;

import java.util.ArrayList;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ApiGateway.Repository.UserRepository;
import com.ApiGateway.entity.UserEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private UserService service;
	
	@Autowired
	private RedisServer redisServer;
	
	Logger logger=LoggerFactory.getLogger(CustomerUserDetailsService.class);
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserEntity entity=new UserEntity();
		
		if(!redisServer.isKeyExist(username, username))
		{
			entity =this.repository.findByEmailIgnoreCase(username);
			if(entity==null)
			{
				throw new ResourcesNotFoundException();
			}
			
			logger.info("add in cache....");
			
			redisServer.addInCache(username, username, entity);
			
			
		}
		else{
			
			String jsonString =(String)redisServer.getFromCache(username, username);
			
			try {
				ObjectMapper mapper=new ObjectMapper();
				Map<String , Object> map=mapper.readValue(jsonString, Map.class);
				entity.setPassword((String)map.get("password"));
				entity.setEmail((String)map.get("email"));
				entity.setId((Long)map.get("id"));
				
				logger.info("get from cache...");
				
			}
			catch (Exception e) {
				System.out.println("Error  "+ e);
			}
		}
		
			
			ArrayList<SimpleGrantedAuthority> permissions;
			
			if(entity!=null)
			{
				permissions=this.service.getAuthorities(entity.getId());
				
			}
			else {
				throw new ResourcesNotFoundException();
			}
			
			return new User(entity.getEmail(), entity.getPassword(), permissions);
			
		
	}

}
