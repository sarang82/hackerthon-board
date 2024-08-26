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
    private Integer id;

    private String title;
    private String content;
    private String name = "익명";
    private Timestamp create_date = Timestamp.valueOf(LocalDateTime.now());

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    // 기본 생성자, Getter 및 Setter는 @Data 어노테이션으로 제공됨
}
