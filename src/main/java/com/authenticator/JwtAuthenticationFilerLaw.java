// package com.authenticator;


// import com.Tokens.CommonJwtUtil;
// import com.entity.Citizen;
// import com.entity.LawEnforcement;
// import com.repository.CitizenRepository;
// import com.repository.LawEnforcementRepository;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
// import org.springframework.stereotype.Component;
// import org.springframework.web.filter.OncePerRequestFilter;

// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import java.io.IOException;
// import java.util.List;

// @Component
// public class JwtAuthenticationFilerLaw extends OncePerRequestFilter {
    
//     @Autowired
//     private CommonJwtUtil jwtUtil;

//     @Autowired
//     private LawEnforcementRepository lawEnforcementRepository;

//     @Override
//     protected void doFilterInternal(HttpServletRequest request,HttpServletResponse response,FilterChain chain)
//     throws ServletException,IOException
//     {
//         String authorizationHeader=request.getHeader("Authorization");
//         if(authorizationHeader!=null&&authorizationHeader.startsWith("Bearer ")){
//             String token=authorizationHeader.substring(7);
//             String email=jwtUtil.extractEmail(token);
            
//             if(email!=null&&SecurityContextHolder.getContext().getAuthentication()==null){
//                   LawEnforcement law=  lawEnforcementRepository.findByEmail(email).orElse(null);

//                   if (law != null && jwtUtil.validateToken(token, law.getPoliceStationEmail())) {
//                     UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
//                         law, null, List.of(() -> law.getRole())); // Set role
//                     authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                     SecurityContextHolder.getContext().setAuthentication(authentication);
//                 }
                
//             }
//         }
//         chain.doFilter(request, response);
//     }
// }
