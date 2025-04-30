package com.authenticator.CitizenAuth;

import com.Tokens.CommonJwtUtil;
import com.entity.Citizen;
import com.repository.CitizenRepository;
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
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    
    @Autowired
    private CommonJwtUtil jwtUtil;

    @Autowired
    private CitizenRepository citizenRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request,HttpServletResponse response,FilterChain chain)
    throws ServletException,IOException
    {
        String authorizationHeader=request.getHeader("Authorization");
        if(authorizationHeader!=null&&authorizationHeader.startsWith("Bearer ")){
            String token=authorizationHeader.substring(7);
            String email=jwtUtil.extractEmail(token);
            
            if(email!=null&&SecurityContextHolder.getContext().getAuthentication()==null){
                  Citizen citizen=  citizenRepository.findByEmail(email).orElse(null);

                if(citizen!=null && jwtUtil.validateToken(token,citizen.getEmail())){
                    UsernamePasswordAuthenticationToken authentication=new UsernamePasswordAuthenticationToken(citizen,null,null);
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
                
            }
        }
        chain.doFilter(request, response);
    }
}
