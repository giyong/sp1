package com.study.admin.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.admin.user.dao.UserAdmDao;
import com.study.admin.user.domain.LoginUserVo;
import com.study.admin.user.domain.UserVo;

@Service
public class UserAdmService {

	@Autowired
	private UserAdmDao userAdmDao;

	/**
	 * 사용자 등록
	 * @param userVo
	 * @return
	 */
	public int insertUser(UserVo userVo) {

		return userAdmDao.insertUser(userVo);
	}

	/**
	 * 사용자 조회
	 * @return userVo
	 */
	public LoginUserVo selectUser(LoginUserVo loginUserVo) {

		return userAdmDao.selectUser(loginUserVo);
	}

}
