package dgu.farmer.domain.member.repository;

import dgu.farmer.domain.danger.entity.Danger;
import dgu.farmer.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
