package dgu.farmer.domain.danger.repository;

import dgu.farmer.domain.danger.entity.Danger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DangerRepository extends JpaRepository<Danger, Long> {
}
