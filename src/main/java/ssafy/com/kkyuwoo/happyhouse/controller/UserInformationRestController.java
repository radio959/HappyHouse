package ssafy.com.kkyuwoo.happyhouse.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ssafy.com.kkyuwoo.happyhouse.auth.LoginUser;
import ssafy.com.kkyuwoo.happyhouse.auth.session.SessionUser;

import java.util.Objects;

@CrossOrigin("*")
@RestController
public class UserInformationRestController {

    @GetMapping("userinfo")
    public SessionUser user(@LoginUser SessionUser sessionUser) {
        if(Objects.isNull(sessionUser)) throw new IllegalArgumentException("유저 x");
        return sessionUser;
    }
}
