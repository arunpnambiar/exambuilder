package com.exambuilder.service;

import com.exambuilder.dao.UserDetailsDao;
import com.exambuilder.errormanagement.UserValidation;
import com.exambuilder.model.User;
import com.exambuilder.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserDetailsDao userDetailsDao;
    @Autowired
    JwtUtil jwtUtils;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDetailsDao.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
        return new MyUserDetails(user);
    }

    public String loginByUsernameAndPassword(String username,String password) throws UsernameNotFoundException {
        loadUserByUsername(username);
        try {
            Optional<User> user = Optional.of(userDetailsDao.loginWithUsernameAndPassword(username, password));
            if (!user.isPresent()) {
                throw new UserValidation("user name or password in correct");
            }
            return jwtUtils.generateToken(user.get().getUsername());
        }
        catch(Exception ex){
            throw new UserValidation(ex.getMessage());
        }
    }

    public User saveUser(User user) {
        User obj = new User();
        UserRole userRoleObj  = new UserRole();
        setUserValues(obj,user);
        Optional<User> savedUser = Optional.of(userDetailsDao.save(obj));
        if(savedUser.isPresent() && !user.getRoles().isEmpty()) {
            user.getRoles().forEach(values->{
               userRoleObj.setUser_id(savedUser.get().getId());
               userRoleObj.setRole_id(values.getId());
               userRoleDao.save(userRoleObj);
            });
        }
        return savedUser.get();
    }

    private void setUserValues(User Obj, User user){
        Obj.setUsername(user.getUsername());
        Obj.setPassword(user.getPassword());
    }
}
