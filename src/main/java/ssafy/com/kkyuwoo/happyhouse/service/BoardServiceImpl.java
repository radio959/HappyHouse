package ssafy.com.kkyuwoo.happyhouse.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssafy.com.kkyuwoo.happyhouse.auth.session.SessionUser;
import ssafy.com.kkyuwoo.happyhouse.domain.board.Board;
import ssafy.com.kkyuwoo.happyhouse.domain.board.BoardRepository;
import ssafy.com.kkyuwoo.happyhouse.domain.board.BoardType;
import ssafy.com.kkyuwoo.happyhouse.domain.user.User;
import ssafy.com.kkyuwoo.happyhouse.domain.user.UserRepository;
import ssafy.com.kkyuwoo.happyhouse.dto.BoardResponseDto;
import ssafy.com.kkyuwoo.happyhouse.dto.BoardSaveRequestDto;
import ssafy.com.kkyuwoo.happyhouse.dto.BoardUpdateRequestDto;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<Board> findAllByBoardTypeLike(BoardType boardType) {
        return boardRepository.findAllByBoardTypeLike(boardType);
    }

    @Transactional
    public void save(BoardSaveRequestDto requestDto, SessionUser sessionUser, BoardType boardType){
        User user = userRepository.findByEmail(sessionUser.getEmail()).orElseThrow(() ->
                new IllegalArgumentException("해당 유저가 없습니다. "));

        Board board = Board.builder()
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .user(user)
                .count(0)
                .boardType(boardType)
                .build();

        boardRepository.save(board).getId();
    }

    @Transactional
    public void update(Long id, BoardUpdateRequestDto requestDto){
        Board board = boardRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("해당 게시글이 없습니다. id="+ id));
        board.update(requestDto.getTitle(), requestDto.getContent());
    }

    @Transactional
    public void delete (Long id){
        Board board = boardRepository.findById(id).orElseThrow(()->new
                IllegalArgumentException("해당 게시글이 없습니다. id="+ id));
        boardRepository.delete(board);
    }

    @Transactional
    public BoardResponseDto findById(Long id){
        Board board = boardRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("헤당 게시글이 없습니다. id="+id));
        board.countUpdate();
        return new BoardResponseDto(board);
    }

}
