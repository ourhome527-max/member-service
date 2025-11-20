package com.example.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.domain.Member;
import com.example.domain.dto.UserLoginReq;
import com.example.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {
	private final MemberMapper memberMapper;

	/*
	 * 로그인 처리
	 */
//	public MemberInfoResponse login(UserLoginReq request) throws IllegalArgumentException {
//		Member member = memberMapper.findByUserId(request.getUserId());
//
//		if (member == null) {
//			log.warn("Login failed: User not found ({})", request.getUserId());
//			throw new IllegalArgumentException("아이디 또는 비밀번호가 일치하지 않습니다.");
//		}
//		if (!member.getUserPwd().equals(request.getUserPwd())) {
//			log.warn("Login failed: Password mismatch for user ({})", request.getUserId());
//			throw new IllegalArgumentException("아이디 또는 비밀번호가 일치하지 않습니다.");
//		}
//
//		// 3. 성공적으로 사용자 정보를 반환
//		log.info("Login successful for user ({})", request.getUserId());
//		return new MemberInfoResponse(member);
//	}

	/*
	 * 간단한 로그인 처리 테스트
	 */
	public Member login(UserLoginReq request) {
		String testUserId = "test";
		String testUserPwd = "1111";
		Map<String, String> params = new HashMap<>();
		params.put("memberName", "홍길동");

		memberMapper.testMethod(params);

		if (testUserId.equals(request.getUserId()) && testUserPwd.equals(request.getUserPwd())) {
			return new Member("test", "1111", "홍길동");
		}
		return null;
	}
}
