package com.board.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer boardId; // 게시글 ID (댓글이 속한 게시글을 참조)
    private String name;
    private String content;
    private Timestamp createDate = Timestamp.valueOf(LocalDateTime.now());
}
