package com.example.mapper;

import java.util.Map;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.Member;
import com.example.domain.dto.RegistMemberReq;

@Mapper
public interface MemberMapper {
	void testMethod(Map<String, String> params);

	int testRegist(RegistMemberReq request);

	// 회원 정보 조회
	Member selectMemberById(String memberId);
}
