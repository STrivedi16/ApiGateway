package com.ApiGateway.Config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.ApiGateway.Repository.UserInterface;

public interface UserServiceImpl {

public UserDto registerUser(UserDto dto) throws Exception;
	
	public List<UserInterface> getUserDetails(long id );
	
	public List<UserInterface> getUserDetailsProfile(long id );
	
	public List<UserInterface> getAll(Integer pagesize, Integer pagenumber);
	
	public ArrayList<SimpleGrantedAuthority> getAuthorities(long id );
	
	public String  forgotPassword(String email, UserDto dto) ;
	
	public String deleteUser(long id )throws ResourcesNotFoundException;
}
