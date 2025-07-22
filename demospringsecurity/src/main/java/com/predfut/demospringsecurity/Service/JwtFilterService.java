package com.predfut.demospringsecurity.Service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilterService extends OncePerRequestFilter {
	
	@Autowired
	JwtUtil jwtUtil;
	@Autowired
	MyUsersDetailsService myUsersDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = request.getHeader("Authorization");
		
		if(token != null && token.startsWith("Bearer")) {
			   token = token.substring(7);
			   String userName = jwtUtil.extractByEmployeeName(token);
			   if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null){
				   UserDetails userDetails = myUsersDetailsService.loadUserByUsername(userName);
				   if(jwtUtil.tokenIsValid(token,userName)) {
					   UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken( userDetails,null,userDetails.getAuthorities());
					   authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					   SecurityContextHolder.getContext().setAuthentication(authToken);
				   }
			   }
		}
			filterChain.doFilter(request, response);
		}
		
	}


