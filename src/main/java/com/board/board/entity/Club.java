package com.board.board.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="club_id")
    private Integer Id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String field;

    @Column(nullable = false)
    private Integer number;

    @Column(nullable = false)
    private Timestamp create_date = Timestamp.valueOf(LocalDateTime.now());

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ClubComment> clubComment;

    public String getName() {
        return user != null ? user.getName() : "익명";
    }

    public String getStuId() {
        return user != null ? user.getStu_id() : null;
    }

}
