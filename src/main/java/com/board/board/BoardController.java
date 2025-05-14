package com.board.board;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    // 전체 게시글 조회
    @GetMapping()
    public List<BoardResponse> getAllBoards() {
        return boardService.getBoards();
    }

    // 게시글 생성
    @PostMapping()
    public Board createBoard(@RequestBody CreateBoardRequest request) {
        return boardService.createBoard(request);
    }

    // 게시글 내용 수정
    @PatchMapping()
    public Board updateBoard(@RequestBody UpdateBoardRequest request) {
        return boardService.updateBoard(request);
    }

    // 게시글 ID로 조회
    @GetMapping("/{id}")
    public BoardResponse getBoardById(@PathVariable Long id) {
        return boardService.getBoardById(id);
    }

    // 게시글 삭제
    @DeleteMapping("/{id}")
    public void deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
    }
}
