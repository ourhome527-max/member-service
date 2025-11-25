package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Member;
import com.example.domain.dto.RegistMemberReq;
import com.example.domain.dto.UserLoginReq;
import com.example.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
@Slf4j
public class MemberController {
	private final MemberService memberService;

	// 회원 가입
	@PostMapping("/regist")
	public ResponseEntity registMember(@RequestBody RegistMemberReq request) {
		log.info("request: {}", request);
		int result = memberService.registMember(request);
		if (result > 0) {
			return ResponseEntity.ok(null);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}

	// 로그인
	@PostMapping("/login")
	public ResponseEntity<Member> login(@RequestBody UserLoginReq request) {
		Member loginMember = memberService.login(request);
		if (loginMember != null) {
			return ResponseEntity.ok(loginMember);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}

	// 로그아웃
}
