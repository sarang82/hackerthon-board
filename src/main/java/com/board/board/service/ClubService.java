package com.board.board.service;

import com.board.board.entity.Club;
import com.board.board.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubService {
    @Autowired
    private static ClubRepository clubRepository;

    //글 작성 처리
    public Club write(Club club) {
        return clubRepository.save(club);
    }

    //게시글 리스트 처리
    public List<Club> clubList() {
        return clubRepository.findAll();
    }

    //특정 게시글 불러오기
    public Club clubView(Integer id) {
        return clubRepository.findById(id).get();
    }

    //특정 게시글 삭제
    public void clubDelete(Integer id) {
        clubRepository.deleteById(id);
    }

    // 게시글 수정
    //public Board boardModify(Integer id) {
    //    return boardRepository.findById(id).orElse(null);
    //}

    // 게시글 업데이트
    public Club clubUpdate(Integer id, Club club) {
        Club existingClub = clubRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 게시글입니다."));
        existingClub.setTitle(club.getTitle());
        existingClub.setContent(club.getContent());
        existingClub.setCreate_date(club.getCreate_date());
        return clubRepository.save(existingClub);
    }

    public static Club findById(Integer clubId) {
        return clubRepository.findById(clubId).orElseThrow(() -> new IllegalArgumentException("Invalid club Id: " + clubId));
    }
}
