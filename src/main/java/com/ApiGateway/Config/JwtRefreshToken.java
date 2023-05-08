package com.ApiGateway.Config;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.google.common.base.Function;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtRefreshToken {

	private static final long serialVersionID=-1l;
	private static final long JWT_REFTOKEN_VALIDITY=5*60*60;
	
	private static final String TYPE="Refrsh";
	
	@Value("${jwt.secret}")
	private String secret;
	
	public String getUsernameFromReftoken(String reftoken)
	{
		return getClaimsFromReftoken(reftoken, Claims::getSubject);
		
	}
	
	public Date getExpirationDateFromReftoken(String reftoken)
	{
		return getClaimsFromReftoken(reftoken, Claims::getExpiration);
	}
	
	private <T> T getClaimsFromReftoken(String reftoken,Function<Claims, T>claimResolver)
	{
		Claims claims=getAllClaimsFromRefToken(reftoken);
		
		return claimResolver.apply(claims);
	}
	
	private Claims getAllClaimsFromRefToken(String reftoken)
	{
		return Jwts
				.parser().setSigningKey(secret).parseClaimsJws(reftoken).getBody();
	}
	
	public String getTypeFromReftoken(String reftoken)
	{
		final Claims claims=Jwts.parser().setSigningKey(secret).parseClaimsJws(reftoken).getBody();
	
	
		return (String)claims.get("type");
	}
	
	
	public String generateRefToken(UserDetails details)
	{
		Map<String ,Object> map=new HashMap<>();
		map.put("type", TYPE);
		return dogenerate(map,details.getUsername());
	}
			
	private String dogenerate(Map<String , Object>claims, String object)
	{
		return Jwts.builder().setClaims(claims).setSubject(object).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis()+JWT_REFTOKEN_VALIDITY*100000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}
	
}
