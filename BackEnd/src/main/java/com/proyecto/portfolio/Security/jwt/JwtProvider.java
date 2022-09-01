
package com.proyecto.portfolio.Security.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class JwtProvider {
       private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);
       
       
       @Value("${jwt.secret}")
       private String secret;
       private int expiration;
}
