package com.example.youtube.demo.repository;


import com.example.youtube.demo.entity.LikesAndDislikesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikesAndDislikesRepo extends JpaRepository<LikesAndDislikesEntity,Long> {
}

