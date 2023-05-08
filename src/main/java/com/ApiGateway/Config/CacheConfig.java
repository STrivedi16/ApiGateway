package com.ApiGateway.Config;

import java.time.Duration;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableCaching
@EnableRedisRepositories
public class CacheConfig {

	private Logger log=LoggerFactory.getLogger(CacheConfig.class);
	
	@Value("${spring.redis.port}")
	private int port;
	
	@Value("${spring.redis.host}")
	private String host;

	public CacheConfig() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Bean
	public LettuceConnectionFactory connectionFactory()
	{
		RedisStandaloneConfiguration configuration=new RedisStandaloneConfiguration();
		log.info("Caching is invoed...");
		configuration.setHostName(host);
		configuration.setPort(port);
		
		return new LettuceConnectionFactory(configuration);
	}
	
	@Bean
	public RedisCacheConfiguration cacheConfiguration()
	{
		RedisCacheConfiguration cacheConfiguration=RedisCacheConfiguration.defaultCacheConfig()
				.entryTtl(Duration.ofSeconds(600)).disableCachingNullValues();
		
		return cacheConfiguration;
	}
	
	@Bean
	public RedisCacheManager  cacheManager()
	{
		RedisCacheManager rcm=RedisCacheManager.builder(connectionFactory()).cacheDefaults(cacheConfiguration())
				.transactionAware().
				build();
		
		return rcm;
	}
	
	public RedisTemplate<String , Object>  redisTemplate()
	{
		RedisTemplate<String , Object> template=new RedisTemplate<>();
		
		RedisSerializer<String> serializer=new StringRedisSerializer();
		
		JdkSerializationRedisSerializer redisSerializer=new JdkSerializationRedisSerializer();
		
		LettuceConnectionFactory lcf=connectionFactory();
		lcf.afterPropertiesSet();
		template.setConnectionFactory(lcf);
		template.setKeySerializer(serializer);
		template.setHashKeySerializer(serializer);
		template.setValueSerializer(redisSerializer);
		template.setHashValueSerializer(redisSerializer);
		template.setEnableTransactionSupport(true);
		template.afterPropertiesSet();
		
		return template;
		
		
	}
}
