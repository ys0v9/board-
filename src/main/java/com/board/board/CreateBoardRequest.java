package com.board.board;

public record CreateBoardRequest(
        String title,
        String content
) {
}
