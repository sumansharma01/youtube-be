package com.example.youtube.demo.repository;


import com.example.youtube.demo.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepo extends JpaRepository<TagEntity,Long> {
}
