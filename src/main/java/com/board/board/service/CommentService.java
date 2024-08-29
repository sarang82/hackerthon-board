package com.board.board.service;

import com.board.board.entity.Comment;
import com.board.board.repository.CommentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Transactional
    public Comment write(Comment comment) {
        return commentRepository.save(comment);
    }

    public List<Comment> findCommentsByBoardId(Integer boardId) {
        return commentRepository.findByBoardId(boardId);
    }

    @Transactional
    public void delete(Integer id) {
        commentRepository.deleteById(id);
    }
}
