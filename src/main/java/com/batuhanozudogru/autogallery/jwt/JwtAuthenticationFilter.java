package com.batuhanozudogru.autogallery.jwt;

import com.batuhanozudogru.autogallery.enums.MessageType;
import com.batuhanozudogru.autogallery.exception.BaseException;
import com.batuhanozudogru.autogallery.exception.ErrorMessage;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsService userDetailsService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = header.substring(7);
        String username;
        try {
            username = jwtService.getUsernameFromToken(token);
            if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                if(userDetails!=null && jwtService.isTokenValid(token)){
                    UsernamePasswordAuthenticationToken authenticationToken = new
                    UsernamePasswordAuthenticationToken(username,null,userDetails.getAuthorities());

                    authenticationToken.setDetails(userDetails);

                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        }catch (ExpiredJwtException ex){
            throw new BaseException(new ErrorMessage(MessageType.TOKEN_IS_EXPIRED,ex.getMessage()));
        }
        catch (Exception e) {
            throw new BaseException(new ErrorMessage(MessageType.GENERAL_EXCEPTION,e.getMessage()));
        }
        filterChain.doFilter(request,response);

    }
}
