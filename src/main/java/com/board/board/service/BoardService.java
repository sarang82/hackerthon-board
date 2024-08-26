package com.board.board.service;

import com.board.board.entity.Board;
import com.board.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;
    //글 작성 처리
    public void write(Board board) {
        boardRepository.save(board);
    }

    //게시글 리스트 처리
    public List<Board> boardList() {
        return boardRepository.findAll();
    }

    //특정 게시글 불러오기
    public Board boardView(Integer id) {
        return boardRepository.findById(id).get();
    }

    //특정 게시글 삭제
    public void boardDelete(Integer id) {
        boardRepository.deleteById(id);
    }

    // 게시글 수정
    public Board boardModify(Integer id) {
        return boardRepository.findById(id).orElse(null);
    }

    // 게시글 업데이트
    public void boardUpdate(Integer id, Board board) {
        Board existingBoard = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 게시글입니다."));
        existingBoard.setTitle(board.getTitle());
        existingBoard.setContent(board.getContent());
        existingBoard.setCreate_date(board.getCreate_date());
        boardRepository.save(existingBoard);
    }

    public Board findById(Integer boardId) {
        return boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException("Invalid board Id: " + boardId));
    }
}
