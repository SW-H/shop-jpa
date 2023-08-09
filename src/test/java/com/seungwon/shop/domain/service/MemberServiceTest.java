package com.seungwon.shop.domain.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.seungwon.shop.domain.Member;
import com.seungwon.shop.domain.repository.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class MemberServiceTest {
	@Autowired
	MemberService memberService;
	@Autowired
	MemberRepository memberRepository;

	@Test
	public void 회원가입() throws Exception {
		// given
		Member member = new Member();
		member.setName("한");

		// when
		Long savedId = memberService.join(member);

		// then
		assertEquals(member, memberRepository.findOne(savedId));
	}

	@Test
	public void 중복_회원_예외() throws Exception {
		// given
		Member member1 = new Member();
		member1.setName("Han");

		Member member2 = new Member();
		member2.setName("Han");

		// when
		memberService.join(member1);

		// then
		assertThrows(IllegalStateException.class,
				() -> memberService.join(member2));
	}

}
