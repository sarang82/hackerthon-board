package com.board.board.controller;

import com.board.board.entity.Board;
import com.board.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
@CrossOrigin(origins = "*") //여기
public class BoardController {

    @Autowired
    private BoardService boardService;

    // 모든 게시글 리스트를 JSON으로 반환
    @GetMapping("/list")
    public List<Board> boardList() {
        return boardService.boardList();
    }

    // 특정 게시글을 JSON으로 반환
    @GetMapping("/view")
    public Board boardView(@RequestParam("id") Integer id) {
        return boardService.boardView(id);
    }

    // 새 게시글 작성
    @PostMapping("/write")
    public void boardWrite(@RequestBody Board board) {
        boardService.write(board);
    }

    // 게시글 삭제
    @DeleteMapping("/delete")
    public void boardDelete(@RequestParam("id") Integer id) {
        boardService.boardDelete(id);
    }

     //게시글 수정
    @GetMapping("/modify/{id}")
    public Board boardModify(@PathVariable("id") Integer id) {
        return boardService.boardModify(id);
    }

    // 게시글 수정 완료
    @PostMapping("/modify/update/{id}")
    public void boardUpdate(@PathVariable("id") Integer id, @RequestBody Board board) {
        boardService.boardUpdate(id, board);
    }

    //@GetMapping("/modify/{id}")
    //public Board boardModify(@PathVariable("id") Integer id) {
    //    return boardService.boardModify(id);
    //}
    //@PostMapping("/update/{id}")
    //public void boardUpdate(@PathVariable("id") Integer id, Board board) {
    //    Board boardTemp = boardService.boardView(id);
    //    boardTemp.setTitle(board.getTitle());
    //    boardTemp.setContent(board.getContent());
    //    board.setCreate_date(board.getCreate_date());
    //    boardService.write(boardTemp);
    //}
}