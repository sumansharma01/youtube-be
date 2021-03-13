package com.example.youtube.demo.repository;

import com.example.youtube.demo.entity.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface VideoRepo extends JpaRepository<VideoEntity,Long> {
}
