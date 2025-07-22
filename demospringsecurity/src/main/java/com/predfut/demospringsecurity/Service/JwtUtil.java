package com.predfut.demospringsecurity.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.predfut.demospringsecurity.Dto.Users;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {


	private static final String SECRET_KEY = "MySuperSecretKeyForJwtSigning1234"; // ✅ 32+ characters
	private static final Key SIGNING_KEY = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
	 private static final Logger log=LoggerFactory.getLogger(JwtUtil.class);

	    public String generateToken(Users users) {
	    	
	    	Map<String,Object>claims=new HashMap<>();
	    	
	    		    	log.info("Generating JWT token for user: "+users.getuId());
	    	
	        // 🔥 One single method to generate token with custom fields
	       
	            return Jwts.builder()                     
	                   
	                    .setSubject(users.getuId())            // main subject
	                    .setIssuedAt(new Date(System.currentTimeMillis()))
	                    .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
	                    .signWith(SIGNING_KEY, SignatureAlgorithm.HS256) 
	                    .compact();
	    
//	    			return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWUsImlhdCI6MTUxNjIzOTAyMn0.KMUFsIDTnFmyG3nMiGM6H9FNFUROf3wh7SmqJp-QV30";
//	        
	    }

		public String extractByEmployeeName(String token) {
			log.debug("Extracted username from token: " );
			
			return Jwts.parserBuilder().setSigningKey(SIGNING_KEY).build().parseClaimsJws(token).getBody().getSubject();
		}

		public boolean tokenIsValid(String token ,String userName) {
		
			try {
				log.info("validating token for:"+userName);
				Jwts.parserBuilder().setSigningKey(SIGNING_KEY).build().parseClaimsJws(token);
				return true;
				}catch(JwtException e) {
					return false;
				}
			 
		}


	    
}
