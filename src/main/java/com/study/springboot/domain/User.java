package com.study.springboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class User {
	private Long id; // 用户的唯一标识
 	private String name;
	private Integer age;
}
