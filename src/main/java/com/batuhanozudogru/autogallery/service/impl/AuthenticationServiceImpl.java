package com.batuhanozudogru.autogallery.service.impl;

import com.batuhanozudogru.autogallery.dto.AuthRequest;
import com.batuhanozudogru.autogallery.dto.DtoUser;
import com.batuhanozudogru.autogallery.model.User;
import com.batuhanozudogru.autogallery.repository.UserRepository;
import com.batuhanozudogru.autogallery.service.AuthenticationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private User createUser (AuthRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setCreatedTime(new Date());
        return user;
    }
    @Override
    public DtoUser register(AuthRequest request) {
        DtoUser dtoUser = new DtoUser();

        User user = createUser(request);
        User savedUser = userRepository.save(user);

        BeanUtils.copyProperties(savedUser, dtoUser);

        return dtoUser;
    }
}
