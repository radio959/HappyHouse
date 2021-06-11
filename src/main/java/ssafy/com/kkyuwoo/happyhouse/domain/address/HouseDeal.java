package ssafy.com.kkyuwoo.happyhouse.domain.address;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Table(name = "housedeal")
@Entity
public class HouseDeal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no")
    private Integer no;

    @Column(name = "dong", length = 30, nullable = false)
    private String dong;

    @Column(name = "apt_name", length = 50, nullable = false)
    private String aptName;

    @Column(name = "code", length = 30, nullable = false)
    private String code;

    @Column(name = "deal_amount", length = 50, nullable = false)
    private String dealAmount;

    @Column(name = "build_year", length = 30)
    private String buildYear;

    @Column(name = "deal_year", length = 30)
    private String dealYear;

    @Column(name = "deal_month", length = 30)
    private String dealMonth;

    @Column(name = "deal_day", length = 30)
    private String dealDay;

    @Column(name = "area", length = 30)
    private String area;

    @Column(name = "floor", length = 30)
    private String floor;

    @Column(name = "jibun", length = 30)
    private String jibun;

    @Column(name = "type", length = 30)
    private String type;

    @Column(name = "rent_money", length = 30)
    private String rentMoney;

    @Builder
    public HouseDeal(Integer no, String dong, String aptName, String code, String dealAmount, String buildYear, String dealYear, String dealMonth, String dealDay, String area, String floor, String jibun, String type, String rentMoney) {
        this.no = no;
        this.dong = dong;
        this.aptName = aptName;
        this.code = code;
        this.dealAmount = dealAmount;
        this.buildYear = buildYear;
        this.dealYear = dealYear;
        this.dealMonth = dealMonth;
        this.dealDay = dealDay;
        this.area = area;
        this.floor = floor;
        this.jibun = jibun;
        this.type = type;
        this.rentMoney = rentMoney;
    }
}
