package ssafy.com.kkyuwoo.happyhouse.auth.oauth2.Attributes;

import lombok.Builder;
import lombok.Getter;
import ssafy.com.kkyuwoo.happyhouse.auth.oauth2.OAuthAttribute;
import ssafy.com.kkyuwoo.happyhouse.domain.user.Role;
import ssafy.com.kkyuwoo.happyhouse.domain.user.SocialType;
import ssafy.com.kkyuwoo.happyhouse.domain.user.User;

import java.util.Map;

@Getter
public class FaceBookAttribute implements OAuthAttribute {

    private static final String NAME = "name";
    private static final String EMAIL = "email";
    private static final String PICTURE = "picture";

    private Map<String, Object> attributes;
    private String nameAttributeKey; // 사용자 이름은 key:value 형태로 되어있기에 이에 해당하는 키값을 구해야한다.
    private String name;
    private String email;
    private String picture;
    private SocialType socialType;

    @Builder
    private FaceBookAttribute(Map<String, Object> attributes, String nameAttributeKey, String name, String email, String picture, SocialType socialType) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.socialType = socialType;
    }

    public static OAuthAttribute ofFaceBook(String userNameAttributeName, Map<String, Object> attributes) {
        return FaceBookAttribute.builder()
                .name((String) attributes.get(NAME))
                .email((String) attributes.get(EMAIL))
                .picture((String) attributes.get(PICTURE))
                .socialType(SocialType.FACEBOOK)
                .attributes(attributes)
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
