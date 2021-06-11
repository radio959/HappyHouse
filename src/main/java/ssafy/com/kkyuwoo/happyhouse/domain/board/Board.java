package ssafy.com.kkyuwoo.happyhouse.domain.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import ssafy.com.kkyuwoo.happyhouse.domain.BaseTimeEntity;
import ssafy.com.kkyuwoo.happyhouse.domain.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "board")
@Entity
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOARD_ID")
    private Long id;

    @Column(name = "BOARD_TITLE")
    private String title;

    @Column(name = "BOARD_CONTENT")
    private String content;

    @Column(name = "BOARD_COUNT")
    private int count;

    @Enumerated(EnumType.STRING)
    @Column(name = "BOARD_TYPE")
    private BoardType boardType;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @Builder
    public Board(String title, String content, int count, BoardType boardType, User user) {
        this.title = title;
        this.content = content;
        this.count = count;
        this.boardType = boardType;
        this.user = user;
    }

    public Board countUpdate() {
        this.count++;
        return this;
    }

    public Board update(String title, String content) {
        this.title = title;
        this.content = content;
        return this;
    }

}
