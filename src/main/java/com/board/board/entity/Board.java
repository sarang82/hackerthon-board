package com.board.board.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Timestamp create_date = Timestamp.valueOf(LocalDateTime.now());

    // 여러 게시글을 한 사람이 작성할 수 있음
    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    // 한 개의 게시글이 여러 댓글을 가질 수 있음
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    public String getName() {
        return user != null ? user.getName() : "익명";
    }

    public String getStuId() {
        return user != null ? user.getStu_id() : null;
    }
}
