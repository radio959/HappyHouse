package ssafy.com.kkyuwoo.happyhouse.domain.address;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Table(name = "houseinfo")
@Entity
public class HouseInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no")
    private Integer no;

    @Column(name = "dong")
    private String dong;

    @Column(name = "apt_name", length = 50, nullable = false)
    private String aptName;

    @Column(name = "code", length = 30, nullable = false)
    private String code;

    @Column(name = "build_year", length = 30)
    private String buildYear;

    @Column(name = "jibun", length = 30)
    private String jibun;

    @Column(name = "lat", length = 30)
    private String lat;

    @Column(name = "lng", length = 30)
    private String lng;

    @Column(name = "img", length = 50)
    private String img;

    @Builder
    public HouseInfo(Integer no, String dong, String aptName, String code, String buildYear, String jibun, String lat, String lng, String img) {
        this.no = no;
        this.dong = dong;
        this.aptName = aptName;
        this.code = code;
        this.buildYear = buildYear;
        this.jibun = jibun;
        this.lat = lat;
        this.lng = lng;
        this.img = img;
    }
}
