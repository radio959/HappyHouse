package ssafy.com.kkyuwoo.happyhouse.auth.oauth2;

import ssafy.com.kkyuwoo.happyhouse.domain.user.Role;
import ssafy.com.kkyuwoo.happyhouse.domain.user.SocialType;
import ssafy.com.kkyuwoo.happyhouse.domain.user.User;

import java.util.Map;

public interface OAuthAttribute {

    Map<String, Object> getAttributes();

    String getNameAttributeKey();

    String getName();

    String getEmail();

    String getPicture();

    SocialType getSocialType();

    User toEntity();

}
