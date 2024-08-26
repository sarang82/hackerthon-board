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
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    private String name;
    private String content;
    private Timestamp create_date = Timestamp.valueOf(LocalDateTime.now());

    // 기본 생성자, Getter 및 Setter는 @Data 어노테이션으로 제공됨
}
