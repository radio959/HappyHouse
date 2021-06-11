package ssafy.com.kkyuwoo.happyhouse.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ssafy.com.kkyuwoo.happyhouse.dto.DongCodeResponseDto;
import ssafy.com.kkyuwoo.happyhouse.dto.GugunCodeResponseDto;
import ssafy.com.kkyuwoo.happyhouse.dto.HouseInfoResponseDto;
import ssafy.com.kkyuwoo.happyhouse.dto.SidoCodeResponseDto;
import ssafy.com.kkyuwoo.happyhouse.service.AddressServiceImpl;

import java.util.List;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
public class AddressRestController {

    private final AddressServiceImpl addressService;

    @GetMapping("api/v1/sido")
    public ResponseEntity<?> sido() {
        List<SidoCodeResponseDto> sidoGugunCodes = addressService.getSidoCode();
        if (sidoGugunCodes == null || sidoGugunCodes.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(sidoGugunCodes, HttpStatus.OK);
    }

    @GetMapping("api/v1/gungun/{sido}")
    public ResponseEntity<?> gungunSido(@PathVariable(name = "sido") String sido) {
        List<GugunCodeResponseDto> sidoGugunCodes = addressService.getGugunCodeBySido(sido);
        if (sidoGugunCodes == null || sidoGugunCodes.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(sidoGugunCodes, HttpStatus.OK);
    }

    @GetMapping("api/v1/dong/{gugun}")
    public ResponseEntity<?> dongGungun(@PathVariable(name = "gugun") String gugun) {
        List<DongCodeResponseDto> houseInfoDtos = addressService.getDongByGugun(gugun);
        if (houseInfoDtos == null || houseInfoDtos.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(houseInfoDtos, HttpStatus.OK);
    }

    @GetMapping("api/v1/apt/{dong}")
    public ResponseEntity<?> aptDong(@PathVariable(name = "dong") String dong) {
        List<HouseInfoResponseDto> HouseInfoDtos = addressService.getAptByDong(dong);
        if (HouseInfoDtos == null || HouseInfoDtos.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(HouseInfoDtos, HttpStatus.OK);
    }

    @GetMapping("api/v1/apt/{dong}/{aptName}")
    public ResponseEntity<?> aptDong(@PathVariable(name = "dong") String dong, @PathVariable(name = "aptName") String aptName) {
        List<HouseInfoResponseDto> HouseInfoDtos = addressService.getAptByDongAndAptname(dong, aptName);
        if (HouseInfoDtos == null || HouseInfoDtos.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(HouseInfoDtos, HttpStatus.OK);
    }

}
