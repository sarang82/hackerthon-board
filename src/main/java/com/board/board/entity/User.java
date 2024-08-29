package com.board.board.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data //getter, setter 메서드 자동 생성, toString(), equlas() 등 자동 생성
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")  // user_id와 매핑
    private Integer id;

    @Column(nullable = false, unique = true)
    private String stu_id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String gender;

    // 한 명의 사용자가 여러 게시글을 가질 수 있음
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Board> boards;

    // 한 명의 사용자가 여러 댓글을 가질 수 있음
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Club> clubs;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ClubComment> clubComments;

}
