package ssafy.com.kkyuwoo.happyhouse.controller;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ssafy.com.kkyuwoo.happyhouse.auth.LoginUser;
import ssafy.com.kkyuwoo.happyhouse.auth.session.SessionUser;
import ssafy.com.kkyuwoo.happyhouse.domain.board.Board;
import ssafy.com.kkyuwoo.happyhouse.domain.board.BoardType;
import ssafy.com.kkyuwoo.happyhouse.dto.BoardSaveRequestDto;
import ssafy.com.kkyuwoo.happyhouse.dto.BoardUpdateRequestDto;
import ssafy.com.kkyuwoo.happyhouse.service.BoardServiceImpl;

import java.util.List;
import java.util.Objects;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
public class BoardRestController {

    private final BoardServiceImpl boardService;

    @GetMapping("api/v1/boards")
    public ResponseEntity<?> boards(String type) {
        BoardType boardType  = BoardType.of(type);
        List<Board> boards = boardService.findAllByBoardTypeLike(boardType);
        if(Objects.isNull(boards)) {
            return badRequest();
        }
        return ResponseEntity.ok(boards);
    }

    @GetMapping("api/v1/boards/{id}")
    public ResponseEntity<?> boards(@PathVariable("id") Long id) {
        return ResponseEntity.ok(boardService.findById(id));
    }

    @PostMapping("/api/v1/boards")
    public ResponseEntity<?> save(@LoginUser SessionUser user, BoardSaveRequestDto requestDto){
        if(Objects.isNull(user)) return badRequest();
        BoardType boardType = BoardType.of(requestDto.getType());
        boardService.save(requestDto, user, boardType);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/api/v1/boards/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody BoardUpdateRequestDto requestDto){
        boardService.update(id, requestDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/api/v1/boards/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        boardService.delete(id);
        return ResponseEntity.ok().build();
    }

    @NotNull
    private ResponseEntity<Object> badRequest() {
        return ResponseEntity.badRequest().build();
    }

}
