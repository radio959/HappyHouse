package ssafy.com.kkyuwoo.happyhouse.auth.session;

import lombok.Getter;
import ssafy.com.kkyuwoo.happyhouse.domain.user.User;

@Getter
public class SessionUser {

    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this(user.getName(), user.getEmail(), user.getPicture());
    }

    public SessionUser(String name, String email, String picture) {
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

}
