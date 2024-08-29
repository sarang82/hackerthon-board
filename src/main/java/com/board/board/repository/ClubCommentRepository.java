package com.board.board.repository;

import com.board.board.entity.ClubComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubCommentRepository extends JpaRepository<ClubComment, Integer> {
        List<ClubComment> findByClubId(Integer clubId);
}
