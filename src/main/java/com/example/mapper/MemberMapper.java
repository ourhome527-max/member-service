package com.example.mapper;

import java.util.Map;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.Member;

@Mapper
public interface MemberMapper {
	void testMethod(Map<String, String> params);
}
