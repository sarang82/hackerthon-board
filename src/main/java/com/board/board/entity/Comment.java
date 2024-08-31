package com.board.board.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer comment_id;

    // 여러 댓글을 한 게시물이 가질 수 있음
    @ManyToOne
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    // 여러 댓글을 한 사람이 작성할 수 있음
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Timestamp create_date = Timestamp.valueOf(LocalDateTime.now());

    public String getName() {
        return user != null ? user.getName() : "익명";
    }

    public String getStuId() {
        return user != null ? user.getStu_id() : null;
    }
}
