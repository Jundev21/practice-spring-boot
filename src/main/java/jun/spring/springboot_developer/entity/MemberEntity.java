package jun.spring.springboot_developer.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "member_id")
	private Long memberId;

	@Column(name = "member_name")
	private String memberName;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "memberEntity")
	private List<MemberDetailInfo> memberDetailInfoList;


	void add(MemberDetailInfo memberDetailInfo){
		this.memberDetailInfoList.add(memberDetailInfo);
	}

}
