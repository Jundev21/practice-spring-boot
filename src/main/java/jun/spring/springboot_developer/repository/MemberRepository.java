package jun.spring.springboot_developer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jun.spring.springboot_developer.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity,Long> {
}
