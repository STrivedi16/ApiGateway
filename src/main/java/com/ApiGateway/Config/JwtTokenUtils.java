package com.ApiGateway.Config;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.google.common.base.Function;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtils implements Serializable{

	private static final long serialVersionId=-1l;
	private static final long JWT_TOKEN_VALIDITY=50*60*60;
	
	private static final String TYPE="Access";
	
	@Value("${jwt.secret}")
	private String secret;
	
	public String  getUsernameFromToken(String token)
	{
		return getClaimsFromToken(token, Claims::getSubject);
	}
	
	public Date getExpirationDateFromToken(String token)
	{
		return getClaimsFromToken(token, Claims::getExpiration);
	}
	
	private <T>T getClaimsFromToken(String token,Function<Claims, T>claimResolver)
	{
		Claims claims=getAllClaimFromToken(token);
		
		return claimResolver.apply(claims);
	}
	
	
	private Claims getAllClaimFromToken(String token)
	{
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}
	
	public String getTypeFromToken(String token)
	{
		Claims claims =Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	
		return (String)claims.get("type");
	}
	
	public boolean isTokenExpired(String token)
	{
		final Date expireDate=getExpirationDateFromToken(token);
		
		return expireDate.before(new Date());
	}
	
	public String generateToken(UserDetails details)
	{
		Map<String , Object>  map=new HashMap<>();
		
		map.put("type",TYPE);
		
		return dogenerate(map,details.getUsername());
	}
	
	private String dogenerate(Map<String , Object>claims,String object)
	{
		return Jwts.builder().setClaims(claims).setSubject(object)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+JWT_TOKEN_VALIDITY*1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}
	
	public boolean isValidateToken(String token, UserDetails details)
	{
		String username=getUsernameFromToken(token);
		
		return (username.equals(details.getUsername())|| !isTokenExpired(token));
	}
}
