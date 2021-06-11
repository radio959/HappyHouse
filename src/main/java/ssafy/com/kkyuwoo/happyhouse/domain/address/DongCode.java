package ssafy.com.kkyuwoo.happyhouse.domain.address;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@NoArgsConstructor
@Table(name = "dongcode")
@Entity
public class DongCode {

    @Id
    @Column(name = "dongcode")
    private String dongCode;

    @Column(name = "city")
    private String city;

    @Column(name = "gugun")
    private String gugun;

    @Column(name = "dong")
    private String dong;

    @Builder
    public DongCode(String dongCode, String city, String gugun, String dong) {
        this.dongCode = dongCode;
        this.city = city;
        this.gugun = gugun;
        this.dong = dong;
    }

}
