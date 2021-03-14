package com.example.youtube.demo.service;

import com.example.youtube.demo.configuration.SecurityConfiguration;
import com.example.youtube.demo.dto.RegisterRequest;
import com.example.youtube.demo.entity.NotificationEmail;
import com.example.youtube.demo.entity.UserEntity;
import com.example.youtube.demo.entity.VerificationToken;
import com.example.youtube.demo.exception.YoutubeMailException;
import com.example.youtube.demo.repository.UserRepo;
import com.example.youtube.demo.repository.VerificationTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private VerificationTokenRepo verificationTokenRepo;

    @Autowired
    private MailService mailService;

    @Transactional
    public void register(RegisterRequest registerRequest){
        UserEntity userEntity=new UserEntity();
        userEntity.setUsername(registerRequest.getUsername());
        userEntity.setEmail(registerRequest.getEmail());
        userEntity.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        userEntity.setChannelLogo(registerRequest.getChannelLogo());
        userEntity.setCreatedDate(Instant.now());
        userEntity.setSubscribers(0L);
        userEntity.setEnabled(false);

        userRepo.save(userEntity);

        String token=generateVerificationToken(userEntity);
        mailService.sendMail(new NotificationEmail("Please activate your email.",
                userEntity.getEmail(),
                "Thank you for registering. Click the link below to activate your account!"+
                        "http://localhost:8080/v1/youtube/auth/accountVerification/"+token
                ));




    }

    private String generateVerificationToken(UserEntity userEntity) {
        String token= UUID.randomUUID().toString();
        VerificationToken verificationToken=new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUserEntity(userEntity);

        verificationTokenRepo.save(verificationToken);

        return token;

    }

    public void verify(String token) {
        Optional<VerificationToken> verificationToken=verificationTokenRepo.findByToken(token);
        verificationToken.orElseThrow(()->new YoutubeMailException("Invalid token"));
        fetchUserAndEnable(verificationToken.get());

    }

    @Transactional
    void fetchUserAndEnable(VerificationToken verificationToken) {
        String username=verificationToken.getUserEntity().getUsername();
        UserEntity userEntity=userRepo.findByUsername(username).orElseThrow(()->new YoutubeMailException(username+" does not exist"));
        userEntity.setEnabled(true);
        userRepo.save(userEntity);
    }
}
