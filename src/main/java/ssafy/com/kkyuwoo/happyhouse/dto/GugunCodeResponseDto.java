package ssafy.com.kkyuwoo.happyhouse.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssafy.com.kkyuwoo.happyhouse.domain.address.GugunCode;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GugunCodeResponseDto {

    private static final int BEGIN_INDEX = 0;
    private static final int END_INDEX = 5;

    private String gugunCode;
    private String gugunName;

    public GugunCodeResponseDto(GugunCode entity) {
        this(entity.getGugunCode().substring(BEGIN_INDEX, END_INDEX), entity.getGugunName());
    }


}
