package com.DyPham.ProductService.security;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.*;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Slf4j
//@Component
public class JwtFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = getToken(request);

        if (token!=null) {
            try {
                List<GrantedAuthority> authorities = getRoleFromToken(token);

                UserDetails userDetails = org.springframework.security.core.userdetails.User
                        .withUsername("user")
                        .password("123")
                        .authorities(authorities)
                        .build();
                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
                log.info("User details" + userDetails);
            } catch (JwtException exception){
                log.error("Token invalid: {}", exception.getMessage());
            } catch (Exception exception) {
                log.error("Error null invalition do token: {}", exception.getMessage());
            }
        }

        filterChain.doFilter(request, response);
        log.info("TOken: " + token);
        log.info("authorities: " + getRoleFromToken(token));
    }

    public String getToken(HttpServletRequest request) {
        String authHeader =request.getHeader("Authorization");
        if (authHeader != null) {
            String[] authHeaderParts = authHeader.split(" ");
            if (authHeaderParts.length == 2) {
                return authHeaderParts[1];
            }
        }
        return null;
    }

    public List<GrantedAuthority> getRoleFromToken(String token) throws JsonProcessingException {

        String[] chunks = token.split("\\.");

        Base64.Decoder decoder = Base64.getUrlDecoder();

        String payload = new String(decoder.decode(chunks[1]));

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(payload);

        List<GrantedAuthority> authorities = new ArrayList<>();
        if (jsonNode.has("groups")) {
            JsonNode groupNode = jsonNode.get("groups");
            if (groupNode.isArray()) {
                for (final JsonNode node : groupNode) {
                    authorities.add(new SimpleGrantedAuthority(node.asText()));
                }
            }
        }
        return authorities;
    }

}
