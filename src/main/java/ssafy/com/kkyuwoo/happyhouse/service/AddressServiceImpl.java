package ssafy.com.kkyuwoo.happyhouse.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ssafy.com.kkyuwoo.happyhouse.domain.address.*;
import ssafy.com.kkyuwoo.happyhouse.domain.address.repository.*;
import ssafy.com.kkyuwoo.happyhouse.dto.DongCodeResponseDto;
import ssafy.com.kkyuwoo.happyhouse.dto.GugunCodeResponseDto;
import ssafy.com.kkyuwoo.happyhouse.dto.HouseInfoResponseDto;
import ssafy.com.kkyuwoo.happyhouse.dto.SidoCodeResponseDto;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AddressServiceImpl {

    private final BaseAddressRepository baseAddressRepository;
    private final DongCodeRepository dongCodeRepository;
    private final GugunCodeRepository gugunCodeRepository;
    private final HouseDealRepository houseDealRepository;
    private final SidoCodeRepository sidoCodeRepository;
    private final HouseInfoRepository houseInfoRepository;

    public List<BaseAddress> baseAddressList() {
        return baseAddressRepository.findAll();
    }

    public List<DongCode> dongCodeList() {
        return dongCodeRepository.findAll();
    }

    public List<GugunCode> gugunCodeList() {
        return gugunCodeRepository.findAll();
    }

    public List<HouseDeal> houseDealList() {
        Pageable pageable = Pageable.ofSize(1000);
        return houseDealRepository.findAll(pageable).toList();
    }

    public List<SidoCodeResponseDto> getSidoCode() {
        return sidoCodeRepository.findAll().stream()
                .map(SidoCodeResponseDto::new)
                .collect(Collectors.toList());
    }

    public List<GugunCodeResponseDto> getGugunCodeBySido(String sido) {
        return gugunCodeRepository.findAllByGugunCodeStartingWith(sido).stream()
                .map(GugunCodeResponseDto::new)
                .collect(Collectors.toList());
    }

    public List<DongCodeResponseDto> getDongByGugun(String gugun) {
        return dongCodeRepository.findAllByDongCodeStartingWith(gugun).stream()
                .map(DongCodeResponseDto::new)
                .collect(Collectors.toList());
    }

    public List<HouseInfoResponseDto> getAptByDong(String dong) {
        return houseInfoRepository.findAllByDongLike(dong).stream()
                .map(HouseInfoResponseDto::new)
                .collect(Collectors.toList());
    }


    public List<HouseInfoResponseDto> getAptByDongAndAptname(String dong, String aptName) {
        return houseInfoRepository.findAllByDongLikeAndAptNameLike(dong, aptName).stream()
                .map(HouseInfoResponseDto::new)
                .collect(Collectors.toList());
    }
}
