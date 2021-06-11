package ssafy.com.kkyuwoo.happyhouse.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssafy.com.kkyuwoo.happyhouse.domain.address.DongCode;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DongCodeResponseDto {

    private static final int BEGIN_INDEX = 0;
    private static final int END_INDEX = 5;

    private String dongCode;
    private String city;
    private String gugun;
    private String dong;

    public DongCodeResponseDto(DongCode dongCode) {
        this(dongCode.getDongCode().substring(BEGIN_INDEX, END_INDEX), dongCode.getCity(), dongCode.getGugun(), dongCode.getDong());
    }
}
