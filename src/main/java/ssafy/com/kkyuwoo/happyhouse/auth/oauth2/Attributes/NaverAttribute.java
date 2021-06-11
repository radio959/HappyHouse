package ssafy.com.kkyuwoo.happyhouse.auth.oauth2.Attributes;

import lombok.Builder;
import lombok.Getter;
import ssafy.com.kkyuwoo.happyhouse.auth.oauth2.OAuthAttribute;
import ssafy.com.kkyuwoo.happyhouse.domain.user.Role;
import ssafy.com.kkyuwoo.happyhouse.domain.user.SocialType;
import ssafy.com.kkyuwoo.happyhouse.domain.user.User;

import java.util.Map;

@Getter
public class NaverAttribute implements OAuthAttribute {

    private static final String NAME = "name";
    private static final String EMAIL = "email";
    private static final String PROFILE_IMAGE = "profile_image";
    private static final String RESPONSE = "response";

    private Map<String, Object> attributes;
    private String nameAttributeKey; // 사용자 이름은 key:value 형태로 되어있기에 이에 해당하는 키값을 구해야한다.
    private String name;
    private String email;
    private String picture;
    private SocialType socialType;

    @Builder
    private NaverAttribute(Map<String, Object> attributes, String nameAttributeKey, String name, String email, String picture, SocialType socialType) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.socialType = socialType;
    }

    public static OAuthAttribute ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> response = (Map<String, Object>) attributes.get(RESPONSE);
        return NaverAttribute.builder()
                .name((String) response.get(NAME))
                .email((String) response.get(EMAIL))
                .picture((String) response.get(PROFILE_IMAGE))
                .socialType(SocialType.NAVER)
                .attributes(response)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    @Override
    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .role(Role.USER)
                .socialType(socialType)
                .build();
    }
}
