package jun.spring.springboot_developer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jun.spring.springboot_developer.entity.MemberDetailInfo;

public interface MemberDetailRepository extends JpaRepository<MemberDetailInfo,Long> {
}
