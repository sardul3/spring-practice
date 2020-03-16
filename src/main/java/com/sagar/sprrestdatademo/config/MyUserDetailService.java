//package com.sagar.sprrestdatademo.config;
//
//import com.sagar.sprrestdatademo.model.LogInUser;
//import com.sagar.sprrestdatademo.repository.LogInUserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class MyUserDetailService implements UserDetailsService {
//
//    @Autowired
//    LogInUserRepository logInUserRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        Optional<LogInUser> user = logInUserRepository.getUserByUserName(s);
//        return user.map(MyUserDetails::new).get();
//    }
//}
