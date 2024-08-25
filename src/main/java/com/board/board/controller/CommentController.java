package com.board.board.controller;

import com.board.board.entity.Comment;
import com.board.board.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    // 댓글 작성
    @PostMapping("/write")
    public void commentWrite(@RequestBody Comment comment){
        commentService.write(comment);
    }

    // 댓글 삭제
    @DeleteMapping("/delete/{id}")
    public void commentDelete(@PathVariable("id") Integer id) {
        commentService.delete(id);
    }

    // 특정 게시글의 댓글 가져오기
    @GetMapping("/list/{boardId}")
    public List<Comment> getCommentsByBoardId(@PathVariable("boardId") Integer boardId) {
        return commentService.findCommentsByBoardId(boardId);
    }
}
