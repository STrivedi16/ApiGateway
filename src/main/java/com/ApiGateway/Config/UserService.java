package com.ApiGateway.Config;



	import java.util.ArrayList;
	import java.util.Collection;
	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy.Content;
	import org.springframework.data.domain.Page;
	import org.springframework.data.domain.PageRequest;
	import org.springframework.data.domain.Pageable;
	import org.springframework.security.core.authority.SimpleGrantedAuthority;
	import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
	import org.springframework.stereotype.Service;
	import org.springframework.web.client.RestTemplate;

import com.ApiGateway.Repository.UserInterface;
import com.ApiGateway.Repository.UserPermission;
import com.ApiGateway.Repository.UserRepository;
import com.ApiGateway.entity.UserEntity;

	


	@Service
	public class UserService implements UserServiceImpl {

		@Autowired
		private UserRepository repository;
		
//		@Autowired
//		private RestTemplate restTemplate;

		@Autowired
		private BCryptPasswordEncoder  encoder;
		
		
		
		public UserDto registerUser(UserDto dto) throws Exception
		{
			
			UserEntity userData=this.repository.findByEmailIgnoreCase(dto.getEmail());
			
			if(userData!=null)
				throw new Exception("user data alredy stroed");
			
			UserEntity entity=new UserEntity();
			entity.setName(dto.getName());
			entity.setCity(dto.getCity());
			entity.setState(dto.getState());
			entity.setEmail(dto.getEmail());
		//Shivangi@123	
			String password=encoder.encode(dto.getPassword());
			dto.setPassword(password);
			entity.setPassword(password);
			entity.setMobileNo(dto.getMobileNo());
			
			this.repository.save(entity);
			
			return dto;
		}
		

		public List<UserInterface> getUserDetails(long id )
		{
			
//			Collection<? extends UserInterface> li=new ArrayList<>();
//			li.add()
			
//			String url="http://Profile-Service/user/profile/"+id;
//			List=this.restTemplate.getForObject(url, UserProfileInterface.class);
			
			List<UserInterface>  list=this.repository.findById(id, UserInterface.class);
			//list.addAll(li);
			
			if(list.isEmpty())
			{
				throw new ResourcesNotFoundException();
			}
			
			return list;
			
		}
		
		
		public List<UserInterface> getUserDetailsProfile(long id )
		{
			
//			Collection<? extends UserInterface> li=new ArrayList<>();
//			li.add()
			
//			String url="http://Profile-Service/user/profile/"+id;
//			List=this.restTemplate.getForObject(url, UserProfileInterface.class);
			
//			String url="http://Profile-Service/api/user/profile/"+id;
//			List<UserProfileInterface>  s=this.restTemplate.getForObject(url, List.class);
			
			
			
			List<UserInterface>  list=this.repository.findById(id, UserInterface.class);
			
//			List<Object> list2=new ArrayList<>();
//			
//			list2.addAll(list);
//			list2.add(s);
			
			
//			if(list.isEmpty())
//			{
//				throw new ResourcesNotFoundException();
//			}
			
			return list;
			
		}
		
		
	public List<UserInterface> getAll(Integer pagesize, Integer pagenumber) {
			
			Pageable pageable=PageRequest.of(pagenumber, pagesize);
			
			Page<UserInterface> page=this.repository.findAll(pageable,UserInterface.class);
			
			
			
			return page.getContent();
		}
		
		
		
		public ArrayList<SimpleGrantedAuthority> getAuthorities(long id )
		{
			ArrayList<SimpleGrantedAuthority> arrayList=new ArrayList<>();
			
			if( id+"permission" !=null)
			{
				ArrayList<SimpleGrantedAuthority> arrayList2=new ArrayList<>();
				
				List<UserPermission> list=this.repository.getPermission(id, UserPermission.class);
				
				list.forEach(e ->
				
				arrayList2.add(new SimpleGrantedAuthority(e.getPermissions()))
						);
				
				arrayList=arrayList2;
			}
			
			return arrayList;
		}
		
		
		// password shubham - 	Shubham$2711;
		//id 9=mnTrivedi2711$
		

		public String  forgotPassword(String email, UserDto dto) 
		{
			UserEntity entity=this.repository.findByEmailIgnoreCase(email);
			

			if(entity==null)
				{
				throw new ResourcesNotFoundException();
			}
			
			String password=encoder.encode(dto.getPassword());
			
			
			entity.setPassword(password);
			
			this.repository.save(entity);
		
			return "password updated ";
		}


		@Override
		public String deleteUser(long id) throws ResourcesNotFoundException {
			
			UserEntity entity=this.repository.findById(id).orElseThrow(()-> new ResourcesNotFoundException());
			
			this.repository.deleteById(entity.getId());
			
			return "user has been deleted"; 
		}
		
		
		
	}

