package ssafy.com.kkyuwoo.happyhouse.domain.address.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssafy.com.kkyuwoo.happyhouse.domain.address.SidoCode;

import java.util.List;
import java.util.Optional;

@Repository
public interface SidoCodeRepository extends JpaRepository<SidoCode, String> {
}
