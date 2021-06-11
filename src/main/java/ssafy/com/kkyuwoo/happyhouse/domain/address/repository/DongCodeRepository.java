package ssafy.com.kkyuwoo.happyhouse.domain.address.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssafy.com.kkyuwoo.happyhouse.domain.address.DongCode;

import java.util.List;

@Repository
public interface DongCodeRepository extends JpaRepository<DongCode, String> {
    public List<DongCode> findAllByDongCodeStartingWith(String gugun);
}
