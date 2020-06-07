package com.myhexin.tokenverification.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.myhexin.tokenverification.model.User;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    /**
     * 根据用户id生成token
     *
     * @param user user
     * @return token
     */
    public String getToken(User user) {
        String token="";
        token= JWT.create().withAudience(user.getId(), String.valueOf(System.currentTimeMillis()))
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
