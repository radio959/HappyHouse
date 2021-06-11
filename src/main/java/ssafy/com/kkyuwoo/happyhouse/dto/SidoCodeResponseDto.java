package ssafy.com.kkyuwoo.happyhouse.dto;

import lombok.*;
import ssafy.com.kkyuwoo.happyhouse.domain.address.SidoCode;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SidoCodeResponseDto {

    private static final int BEGIN_INDEX = 0;
    private static final int END_INDEX = 2;

    private String sidoCode;
    private String sidoName;

    public SidoCodeResponseDto(SidoCode entity) {
        this(entity.getSidoCode().substring(BEGIN_INDEX, END_INDEX), entity.getSidoName());
    }

}
