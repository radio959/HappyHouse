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
@Table(name = "guguncode")
@Entity
public class GugunCode {

    @Id
    @Column(name = "gugun_code", length = 10)
    private String gugunCode;

    @Column(name = "gugun_name", length = 30)
    private String gugunName;

    @Builder
    public GugunCode(String gugunCode, String gugunName) {
        this.gugunCode = gugunCode;
        this.gugunName = gugunName;
    }
}
