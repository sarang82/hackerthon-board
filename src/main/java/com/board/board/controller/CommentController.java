package com.board.board.controller;

import com.board.board.entity.Board;
import com.board.board.entity.Comment;
import com.board.board.service.BoardService;
import com.board.board.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private BoardService boardService;

    @PostMapping("/write")
    public String commentWrite(@RequestParam("boardId") Integer boardId, @ModelAttribute Comment comment) {
        Board board = boardService.findById(boardId);
        comment.setBoard(board);
        commentService.write(comment);
        return "redirect:/board/view?id=" + boardId;
    }

    @DeleteMapping("/delete")
    public String commentDelete(@RequestParam("id") Integer id, @RequestParam("boardId") Integer boardId) {
        commentService.delete(id);
        return "redirect:/board/view?id=" + boardId;
    }

    @GetMapping("/view")
    public String viewBoard(@RequestParam("id") Integer id, Model model) {
        // 게시글 조회 (게시글 엔티티와 댓글을 포함)
        Board board = boardService.findById(id);
        List<Comment> comments = commentService.findCommentsByBoardId(id);

        model.addAttribute("view", board);
        model.addAttribute("comments", comments);

        return "boardview";  // 댓글 목록을 보여줄 페이지
    }

}
