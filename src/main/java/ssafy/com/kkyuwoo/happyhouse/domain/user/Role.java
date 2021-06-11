package ssafy.com.kkyuwoo.happyhouse.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    USER("USER", "일반 회원"),
    MANAGER("MANAGER", "중간 관리자"),
    ADMIN("ADMIN", "관리자");

    private final String key;
    private final String description;

}

