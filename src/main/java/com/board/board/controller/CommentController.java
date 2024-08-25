package com.board.board.controller;

import com.board.board.entity.Comment;
import com.board.board.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/write")
    public void commentWrite(@RequestBody Comment comment){
        commentService.write(comment);
    }

    @DeleteMapping("/delete")
    public void commentDelete(@PathVariable("id") Integer id) {
        commentService.commentDelete(id);
    }
}
