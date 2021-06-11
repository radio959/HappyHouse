package ssafy.com.kkyuwoo.happyhouse.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssafy.com.kkyuwoo.happyhouse.domain.address.HouseInfo;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class HouseInfoResponseDto {

    private Integer no;
    private String dong;
    private String aptName;
    private String code;
    private String buildYear;
    private String jibun;
    private String lat;
    private String lng;
    private String img;


    public HouseInfoResponseDto(HouseInfo houseInfo) {
        this(houseInfo.getNo(), houseInfo.getDong(), houseInfo.getAptName(), houseInfo.getCode(),
                houseInfo.getBuildYear(), houseInfo.getJibun(), houseInfo.getLat(), houseInfo.getLng(), houseInfo.getImg());
    }
}
