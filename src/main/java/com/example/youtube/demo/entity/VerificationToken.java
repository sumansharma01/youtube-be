package com.example.youtube.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import java.time.Instant;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VerificationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "verification_token_id")
    private Long id;

    private String token;

    @OneToOne(fetch = FetchType.LAZY)
    private UserEntity userEntity;

    private Instant expiryDate;
}
