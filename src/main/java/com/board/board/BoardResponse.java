package com.board.board;

public record BoardResponse(
        Long id,
        String title,
        String content
) {
    public static BoardResponse of(Board board) {
        return new BoardResponse(
                board.getId(),
                board.getTitle(),
                board.getContent()
        );
    }
}

