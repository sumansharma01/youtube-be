package com.example.youtube.demo.repository;

import com.example.youtube.demo.entity.CommentEntity;
import com.example.youtube.demo.entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationTokenRepo extends JpaRepository<VerificationToken,Long> {
}
