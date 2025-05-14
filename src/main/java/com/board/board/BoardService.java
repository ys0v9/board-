package com.board.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    // 게시글 전체 조회
    public List<BoardResponse> getBoards() {
        List<Board> boards = boardRepository.findAll();
        return boards.stream()
                .map(BoardResponse::of)
                .collect(Collectors.toList());
    }

    // 게시글 생성
    public Board createBoard(CreateBoardRequest request) {
        Board board = Board.builder()
                .title(request.title())
                .content(request.content())
                .build();
        return boardRepository.save(board);
    }

    // 게시글 내용 수정
    @Transactional
    public Board updateBoard(UpdateBoardRequest request) {
        Board board = boardRepository.findById(request.id()).orElse(null);
        if (board == null) {
            throw new IllegalArgumentException("해당 게시글이 없습니다.");
        }
        board.setContent(request.content());
        return board;
    }

    // 게시글 ID로 조회
    public BoardResponse getBoardById(Long id) {
        Board board = boardRepository.findById(id).orElse(null);
        if (board == null) {
            throw new IllegalArgumentException("해당 게시글이 없습니다.");
        }
        return BoardResponse.of(board);
    }

    // 게시글 삭제
    public void deleteBoard(Long id) {
        Board board = boardRepository.findById(id).orElse(null);
        if (board == null) {
            throw new IllegalArgumentException("해당 게시글이 없습니다.");
        }
        boardRepository.delete(board);
    }
}
