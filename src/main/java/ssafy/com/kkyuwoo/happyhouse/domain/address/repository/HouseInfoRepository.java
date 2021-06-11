package ssafy.com.kkyuwoo.happyhouse.domain.address.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssafy.com.kkyuwoo.happyhouse.domain.address.HouseInfo;

import java.util.List;

@Repository
public interface HouseInfoRepository extends JpaRepository<HouseInfo, Integer> {

    List<HouseInfo> findAllByCodeLike(String gugun);
    List<HouseInfo> findAllByDongLike(String dong);
    List<HouseInfo> findAllByDongLikeAndAptNameLike(String dong, String aptName);

}
