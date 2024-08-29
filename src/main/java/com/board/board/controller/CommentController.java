package com.board.board.controller;

import com.board.board.entity.Board;
import com.board.board.entity.Comment;
import com.board.board.service.BoardService;
import com.board.board.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inhatc/comment/board")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private BoardService boardService;

    @PostMapping("/write")
    public Comment commentWrite(@RequestParam("boardId") Integer boardId, @ModelAttribute Comment comment) {
        Board board = boardService.findById(boardId);
        comment.setBoard(board);
        return commentService.write(comment);
    }

    @DeleteMapping("/delete{id}")
    public void commentDelete(@RequestParam("id") Integer id, @RequestParam("boardId") Integer boardId) {
        commentService.delete(id);
    }

    @GetMapping("/view{boardId}")
    public List<Comment> viewBoard(@PathVariable("boardId") Integer boardId) {
        // 게시글 조회 (게시글 엔티티와 댓글을 포함)
        return commentService.findCommentsByBoardId(boardId);
    }

}
