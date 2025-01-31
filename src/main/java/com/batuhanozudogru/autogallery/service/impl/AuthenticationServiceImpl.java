package com.batuhanozudogru.autogallery.service.impl;

import com.batuhanozudogru.autogallery.dto.AuthRequest;
import com.batuhanozudogru.autogallery.dto.AuthResponse;
import com.batuhanozudogru.autogallery.dto.DtoUser;
import com.batuhanozudogru.autogallery.enums.MessageType;
import com.batuhanozudogru.autogallery.exception.BaseException;
import com.batuhanozudogru.autogallery.exception.ErrorMessage;
import com.batuhanozudogru.autogallery.jwt.JwtService;
import com.batuhanozudogru.autogallery.model.RefreshToken;
import com.batuhanozudogru.autogallery.model.User;
import com.batuhanozudogru.autogallery.repository.RefreshTokenRepository;
import com.batuhanozudogru.autogallery.repository.UserRepository;
import com.batuhanozudogru.autogallery.service.AuthenticationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    private User createUser (AuthRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setCreatedTime(new Date());
        return user;
    }

    private RefreshToken createRefreshToken(User user){
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setUser(user);
        refreshToken.setCreatedTime(new Date());
        refreshToken.setExpiryDate(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 4));
        refreshToken.setRefreshToken(UUID.randomUUID().toString());
        return refreshToken;
    }
    @Override
    public DtoUser register(AuthRequest request) {
        DtoUser dtoUser = new DtoUser();

        User user = createUser(request);
        User savedUser = userRepository.save(user);

        BeanUtils.copyProperties(savedUser, dtoUser);

        return dtoUser;
    }

    @Override
    public AuthResponse authenticate(AuthRequest request) {


        try {
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
            authenticationProvider.authenticate(authenticationToken);

            Optional<User> optionalUser = userRepository.findByUsername(request.getUsername());

            String accessToken = jwtService.generateToken(optionalUser.get());


            RefreshToken savedRefreshToken = refreshTokenRepository.save(createRefreshToken(optionalUser.get()));

            return new AuthResponse(accessToken, savedRefreshToken.getRefreshToken());


        } catch (Exception e) {
            throw new BaseException(new ErrorMessage(MessageType.USERNAME_OR_PASSWORD_IS_WRONG, e.getMessage()));
        }
    }
}
