package com.board.board;

public record UpdateBoardRequest(
        Long id,
        String content
) {
}

