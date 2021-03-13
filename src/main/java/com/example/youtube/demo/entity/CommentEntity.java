package com.example.youtube.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "comment_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "comment_table")
    private Long id;

    @Lob
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    private VideoEntity videoEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity userEntity;

    private Instant createdDate;


}
