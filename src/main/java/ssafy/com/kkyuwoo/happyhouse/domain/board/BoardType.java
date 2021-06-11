package ssafy.com.kkyuwoo.happyhouse.domain.board;

import java.util.Arrays;

public enum BoardType {
    FREE_BOARD("자유게시판"),
    QNA("질의응답");

    private String type;

    BoardType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static BoardType of(String boardType) {
        return Arrays.stream(values())
                .filter(enumType -> enumType.type.equals(boardType))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 타입의 게시글은 없습니다."));
    }
}
