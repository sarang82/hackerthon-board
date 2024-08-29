package com.board.board.service;

import com.board.board.entity.ClubComment;
import com.board.board.repository.ClubCommentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubCommentService {

    private final ClubCommentRepository clubCommentRepository;

    @Autowired
    public ClubCommentService(ClubCommentRepository clubCommentRepository) {
        this.clubCommentRepository = clubCommentRepository;
    }

    @Transactional
    public ClubComment write(ClubComment clubComment) { return clubCommentRepository.save(clubComment);}

    public List<ClubComment> findCommentByClubId(Integer clubId) {
        return clubCommentRepository.findByClubId(clubId);
    }

    @Transactional
    public void delete(Integer id) {
        clubCommentRepository.deleteById(id);
    }


}
