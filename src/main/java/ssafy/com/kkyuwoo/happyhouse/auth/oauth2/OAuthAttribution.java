package ssafy.com.kkyuwoo.happyhouse.auth.oauth2;

import ssafy.com.kkyuwoo.happyhouse.auth.oauth2.Attributes.FaceBookAttribute;
import ssafy.com.kkyuwoo.happyhouse.auth.oauth2.Attributes.GoogleAttribute;
import ssafy.com.kkyuwoo.happyhouse.auth.oauth2.Attributes.KaKaoAttribute;
import ssafy.com.kkyuwoo.happyhouse.auth.oauth2.Attributes.NaverAttribute;

import java.util.Map;
import java.util.Optional;

public enum OAuthAttribution {

    NAVER("naver"),
    KAKAO("kakao"),
    FACEBOOK("facebook"),
    GOOGLE("google");

    private static final String ID = "id";

    private final String vendor;

    OAuthAttribution(String vendor) {
        this.vendor = vendor;
    }

    public static Optional<OAuthAttribute> of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {

        if (NAVER.vendor.equals(registrationId)) {
            return Optional.ofNullable(NaverAttribute.ofNaver(ID, attributes));
        }
        if (KAKAO.vendor.equals(registrationId)) {
            return Optional.ofNullable(KaKaoAttribute.ofKakao(ID, attributes));
        }
        if (FACEBOOK.vendor.equals(registrationId)) {
            return Optional.ofNullable(FaceBookAttribute.ofFaceBook(userNameAttributeName, attributes));
        }
        if (GOOGLE.vendor.equals(registrationId)) {
            return Optional.ofNullable(GoogleAttribute.ofGoogle(userNameAttributeName, attributes));
        }
        return Optional.empty();
    }

}

