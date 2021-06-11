package ssafy.com.kkyuwoo.happyhouse.domain.address;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Table(name = "baseaddress")
@Entity
public class BaseAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no")
    private Integer no;

    @Column(name = "city", length = 30, nullable = false)
    private String city;

    @Column(name = "code", length = 30)
    private String code;

    @Column(name = "dongcode", length = 30)
    private String dongCode;

    @Column(name = "gugun", length = 30)
    private String gugun;

    @Column(name = "dong", length = 30, nullable = false)
    private String dong;

    @Column(name = "lat", length = 20)
    private String lat;

    @Column(name = "lng", length = 20)
    private String lng;

    @Builder
    public BaseAddress(Integer no, String city, String code, String dongCode, String gugun, String dong, String lat, String lng) {
        this.no = no;
        this.city = city;
        this.code = code;
        this.dongCode = dongCode;
        this.gugun = gugun;
        this.dong = dong;
        this.lat = lat;
        this.lng = lng;
    }
}
