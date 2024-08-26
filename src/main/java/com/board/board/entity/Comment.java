package com.board.board.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Data // 기본 생성자, Getter 및 Setter는 @Data 어노테이션으로 제공됨
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // 여러 게시글을 한 게시물이 가질 수 있음
    @ManyToOne
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    // 여러 댓글을 한 사람이 작성할 수 있음
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String name;
    private String content;
    private Timestamp create_date = Timestamp.valueOf(LocalDateTime.now());


}
