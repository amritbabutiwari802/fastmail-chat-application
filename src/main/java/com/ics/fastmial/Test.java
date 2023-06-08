package com.ics.fastmial;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ics.fastmial.repositories.UserRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @GetMapping("/home")
    public String home(){
        return "hello from home";
    }

//
//	@Autowired
//	UserRepository userRepository;
//
//	@RequestMapping("/")
//	@ResponseBody
//	public int getHello() {
//		return 5;
//	}

}




//wap to make matrix muultiplication