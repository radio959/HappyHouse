package ssafy.com.kkyuwoo.happyhouse.domain.address.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssafy.com.kkyuwoo.happyhouse.domain.address.GugunCode;

import java.util.List;

@Repository
public interface GugunCodeRepository extends JpaRepository<GugunCode, String> {
    List<GugunCode> findAllByGugunCodeStartingWith(String sido);
}
