package com.study.admin.user.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVo {

	private Collection<? extends GrantedAuthority> roleList;

	private String id;

	private String email;

	private String name;

	/** 부모 사이트 종류 */
	private String parentSiteTy;

	private String imageUrl;

}
