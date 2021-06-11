package ssafy.com.kkyuwoo.happyhouse.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ssafy.com.kkyuwoo.happyhouse.domain.address.BaseAddress;
import ssafy.com.kkyuwoo.happyhouse.domain.address.DongCode;
import ssafy.com.kkyuwoo.happyhouse.domain.address.GugunCode;
import ssafy.com.kkyuwoo.happyhouse.domain.address.HouseDeal;
import ssafy.com.kkyuwoo.happyhouse.service.AddressServiceImpl;

import java.util.List;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
public class AddressAllDataRestController {

    private final AddressServiceImpl addressService;

    @GetMapping("api/v1/baseaddress")
    public List<BaseAddress> baseAddress(){
        return addressService.baseAddressList();
    }

    @GetMapping("api/v1/dongcode")
    public List<DongCode> dongcode(){
        return addressService.dongCodeList();
    }

    @GetMapping("api/v1/guguncode")
    public List<GugunCode> guguncode(){
        return addressService.gugunCodeList();
    }

    @GetMapping("api/v1/housedeal")
    public List<HouseDeal> housedeal(){
        return addressService.houseDealList();
    }

}
