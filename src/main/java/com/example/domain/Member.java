package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Member {
	private String memberId;
	private String memberPwd;
	private String memberName;

}