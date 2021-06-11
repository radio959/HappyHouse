package ssafy.com.kkyuwoo.happyhouse.domain.address;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssafy.com.kkyuwoo.happyhouse.dto.SidoCodeResponseDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@NoArgsConstructor
@Table(name = "sidocode")
@Entity
public class SidoCode {

    @Id
    @Column(name = "sido_code", length = 10)
    private String sidoCode;

    @Column(name = "sido_name", length = 30)
    private String sidoName;

    @Builder
    public SidoCode(String sidoCode, String sidoName) {
        this.sidoCode = sidoCode;
        this.sidoName = sidoName;
    }

}
