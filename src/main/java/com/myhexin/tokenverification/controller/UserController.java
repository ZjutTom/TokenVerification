package com.myhexin.tokenverification.controller;

import com.alibaba.fastjson.JSONObject;
import com.myhexin.tokenverification.annotation.PassToken;
import com.myhexin.tokenverification.annotation.UserLoginToken;
import com.myhexin.tokenverification.model.User;
import com.myhexin.tokenverification.service.TokenService;
import com.myhexin.tokenverification.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;
    //登录
    @PostMapping("/login")
    public Object login(@RequestBody User user){
        JSONObject jsonObject=new JSONObject();
        User userForBase=userService.findByUsername(user);
        if(userForBase==null){
            jsonObject.put("message","登录失败,用户不存在");
            return jsonObject;
        }else {
            if (!userForBase.getPassword().equals(user.getPassword())){
                jsonObject.put("message","登录失败,密码错误");
                return jsonObject;
            }else {
                String token = tokenService.getToken(userForBase);
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                return jsonObject;
            }
        }
    }

    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }

    @UserLoginToken
    @RequestMapping("/passToken")
    public String passToken() {
        return "pass token";
    }
}
