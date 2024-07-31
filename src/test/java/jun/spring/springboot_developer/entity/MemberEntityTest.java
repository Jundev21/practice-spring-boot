package jun.spring.springboot_developer.entity;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jun.spring.springboot_developer.repository.MemberDetailRepository;
import jun.spring.springboot_developer.repository.MemberRepository;

@SpringBootTest
@Transactional
class MemberEntityTest {

	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private MemberDetailRepository memberDetailRepository;

	@Test
	void test() {
		MemberEntity membera = MemberEntity.builder()
			.memberName("test")
			.memberDetailInfoList(new ArrayList<>())
			.build();

		MemberEntity memberEntity = memberRepository.save(membera);

		MemberDetailInfo memberDetailInfo1 = MemberDetailInfo.builder()
			.memberDetailTitle("detailTitle")
			.memberEntity(memberEntity)
			.build();

		MemberDetailInfo memberDetailInfo2 = MemberDetailInfo.builder()
			.memberDetailTitle("detailTitle2")
			.memberEntity(memberEntity)
			.build();

		MemberDetailInfo memberDetailInfo11 = memberDetailRepository.save(memberDetailInfo1);
		memberEntity.add(memberDetailInfo11);

		MemberDetailInfo memberDetailInfo22 = memberDetailRepository.save(memberDetailInfo2);
		memberEntity.add(memberDetailInfo22);

		entityManager.flush();
		entityManager.clear();
		List<MemberEntity> members = memberRepository.findAll();
		for (MemberEntity member : members) {
			List<MemberDetailInfo> details = member.getMemberDetailInfoList();
			for (MemberDetailInfo detail : details) {
				System.out.println(detail.getMemberDetailTitle());
			}
		}
	}
}