package com.board.board.controller;

import com.board.board.entity.Board;
import com.board.board.service.BoardService;
import com.board.board.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BoardController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write")
    public String boardWriteForm(){
        return "boardWrite";
    }

    @PostMapping("/board/writepro")
    public String boardWritePro(Board board){
        boardService.write(board);
        return "redirect:/board/write";
    }

    @GetMapping("/board/list")
    public String boardList(Model model){
        model.addAttribute("list", boardService.boardList());

        return "boardlist";
    }
    @GetMapping("/board/view")
    public String boardView(Model model, @RequestParam("id") Integer id){
        Board board = boardService.boardView(id);
        model.addAttribute("view", board);
        return "boardview";
    }
    @GetMapping("/board/delete")
    public String boardDelete(@RequestParam("id") Integer id){
        boardService.boardDelete(id);
        return "redirect:/board/list";
    }

    @GetMapping("/board/modify/{id}")
    public String boardModify(@PathVariable("id") Integer id, Model model){
        Board board = boardService.boardView(id);
        model.addAttribute("board", board);
        return "boardmodify";
    }
    @PostMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable("id") Integer id, @ModelAttribute Board board) {
        boardService.boardUpdate(id, board);
        return "redirect:/board/list";
    }

}