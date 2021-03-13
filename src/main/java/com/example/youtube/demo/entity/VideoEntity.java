package com.example.youtube.demo.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "video_table")
@AllArgsConstructor
@NoArgsConstructor
public class VideoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "video_id")
    private Long id;

    private String name;

    @Lob
    private String description;

    private String title;

    private Long views;

    private Instant createdTime;

    private Long LikesAndDislikes;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity userEntity;

    @OneToMany(fetch = FetchType.LAZY)
    private List<TagEntity> tagEntityList;

    @OneToMany(fetch = FetchType.LAZY)
    private List<CommentEntity> commentEntityList;


}
