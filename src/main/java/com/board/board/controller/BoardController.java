package com.board.board.controller;

import com.board.board.entity.Board;
import com.board.board.service.BoardService;
import com.board.board.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inhatc/board")
public class BoardController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private BoardService boardService;

    @GetMapping("/write")
    public Board boardWriteForm(@RequestBody Board board){
        return boardService.write(board);
    }

    //@PostMapping("/board/writepro")
    //public String boardWritePro(Board board){
    //    boardService.write(board);
    //    return "redirect:/board/write";
    //}

    @GetMapping("/main")
    public List<Board> boardList(){
        return boardService.boardList();
    }
    @GetMapping("/view{id}")
    public Board boardView(@PathVariable("id") Integer id){
        return boardService.boardView(id);
    }
    @GetMapping("/delete")
    public void boardDelete(@PathVariable("id") Integer id){
        boardService.boardDelete(id);
    }

    //@GetMapping("/board/modify/{id}")
    //public String boardModify(@PathVariable("id") Integer id, Model model){
    //    Board board = boardService.boardView(id);
    //    model.addAttribute("board", board);
    //    return "boardmodify";
    //}
    @PostMapping("/list/update{id}")
    public Board boardUpdate(@PathVariable("id") Integer id, @RequestBody Board board) {
        return boardService.boardUpdate(id, board);
    }

}