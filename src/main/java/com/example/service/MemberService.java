package com.example.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.domain.Member;
import com.example.domain.dto.MemberLoginReq;
import com.example.domain.dto.RegistMemberReq;
import com.example.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {
	private final MemberMapper memberMapper;

	public int registMember(RegistMemberReq request) {
		return memberMapper.testRegist(request);
	}

	/*
	 * 로그인
	 */
	public Member login(MemberLoginReq request) {

		String requestMemberId = request.getMemberId();
		String requestMemberPwd = request.getMemberPwd();

		Member selectedMember = memberMapper.selectMemberById(requestMemberId);

		if (selectedMember == null) {
			return null; // 로그인 실패
		}

		String selectMemberId = selectedMember.getMemberId();
		String selectMemberPw = selectedMember.getMemberPwd();

		if (requestMemberId.equals(selectMemberId) && requestMemberPwd.equals(selectMemberPw)) {
			return selectedMember; // 로그인 성공
		}

		// 비밀번호 틀림
		return null;
	}
}
