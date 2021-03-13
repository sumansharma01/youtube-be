package com.example.youtube.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikesAndDislikesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="likes_and_dislikes_id")
    private Long id;

    private LikesAndDislikesType likesAndDislikesType;

    @ManyToOne(fetch = FetchType.LAZY)
    private VideoEntity videoEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity userEntity;
}
