package ssafy.com.kkyuwoo.happyhouse.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssafy.com.kkyuwoo.happyhouse.domain.BaseTimeEntity;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "USER_NAME", nullable = false)
    private String name;

    @Column(name = "USER_EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "USER_PICTURE")
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(name = "USER_SOCIAL_TYPE", nullable = false)
    private SocialType socialType;

    @Enumerated(EnumType.STRING)
    @Column(name = "USER_ROLE", nullable = false)
    private Role role;

    @Builder
    public User(String name, String email, String picture, SocialType socialType, Role role) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.socialType = socialType;
        this.role = role;
    }

    public User update(String name, String email, String picture, SocialType socialType) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.socialType = socialType;
        return this;
    }

    public String getRoleKey() {
        return role.getKey();
    }

}
