package ssafy.com.kkyuwoo.happyhouse.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ssafy.com.kkyuwoo.happyhouse.domain.board.Board;
import ssafy.com.kkyuwoo.happyhouse.domain.board.BoardType;
import ssafy.com.kkyuwoo.happyhouse.domain.user.User;

import java.time.LocalDateTime;
import java.util.List;


@AllArgsConstructor
@Getter
public class BoardResponseDto {

    private Long id;
    private String title;
    private String content;
    private int count;
    private BoardType boardType;
    private User user;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public BoardResponseDto(Board board) {
        this(board.getId(), board.getTitle(), board.getTitle(), board.getCount(), board.getBoardType(), board.getUser(),  board.getCreatedDate(), board.getModifiedDate());
    }

}
