package com.board.board.controller;

import com.board.board.entity.Club;
import com.board.board.service.ClubService;
import com.board.board.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inhatc/club")
public class ClubController {
    @Autowired
    private CommentService commentServiceTwo;

    @Autowired
    private ClubService clubService;

    @GetMapping("/write")
    public Club clubWriteForm(@RequestBody Club club){
        return clubService.write(club);
    }

    @GetMapping("/main")
    public List<Club> boardList(){
        return clubService.clubList();
    }
    @GetMapping("/view{id}")
    public Club clubView(@PathVariable("id") Integer id){
        return clubService.clubView(id);
    }
    @GetMapping("/delete")
    public void clubDelete(@PathVariable("id") Integer id){
        clubService.clubDelete(id);
    }

    //@GetMapping("/board/modify/{id}")
    //public String boardModify(@PathVariable("id") Integer id, Model model){
    //    Board board = boardService.boardView(id);
    //    model.addAttribute("board", board);
    //    return "boardmodify";
    //}
    @PostMapping("/list/update{id}")
    public Club clubUpdate(@PathVariable("id") Integer id, @RequestBody Club club) {
        return clubService.clubUpdate(id, club);
    }

}
