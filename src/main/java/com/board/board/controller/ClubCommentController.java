package com.board.board.controller;

import com.board.board.entity.Club;
import com.board.board.entity.ClubComment;
import com.board.board.service.ClubCommentService;
import com.board.board.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inhatc/comment/club")
public class ClubCommentController {
    @Autowired
    private ClubCommentService clubCommentService;

    @Autowired
    private ClubService clubService;

    @PostMapping("/write")
    public ClubComment clubComment(@RequestParam("clubId") Integer clubId, @ModelAttribute ClubComment clubComment) {
        Club club = clubService.findById(clubId);
        clubComment.setClub(club);
        return clubCommentService.write(clubComment);
    }

    @DeleteMapping("/delete{id}")
    public void ClubcommentDelete(@RequestParam("id") Integer id, @RequestParam("clubId") Integer clubId){
        clubCommentService.delete(id);
    }

    @GetMapping("/view{clubId}")
    public List<ClubComment> viewClub(@PathVariable("clubId") Integer clubId){
        return clubCommentService.findCommentByClubId((clubId));
    }
}
