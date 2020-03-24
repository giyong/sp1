package com.study.admin.comm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.admin.comm.dao.CommCodeAdmDao;
import com.study.admin.comm.domain.CommCodeGroupVo;
import com.study.admin.comm.domain.CommCodeVo;

/**
 * 공통코드 서비스
 */
@Service
public class CommCodeAdmService {

	@Autowired
	private CommCodeAdmDao commCodeAdmDao;

	/**
	 * 공통코드그룹 등록
	 * @return
	 */
	public int insertCommCodeGroup(CommCodeGroupVo commCodeGroupVo) {

		return commCodeAdmDao.insertCommCodeGroup(commCodeGroupVo);
	}

	/**
	 * 공통코드그룹 수정
	 * @return
	 */
	public int updateCommCodeGroup(CommCodeGroupVo commCodeGroupVo) {

		return commCodeAdmDao.updateCommCodeGroup(commCodeGroupVo);
	}

	/**
	 * 공통코드그룹 목록 조회
	 * @return
	 */
	public int selectCommCodeGroupPageCount(CommCodeGroupVo commCodeGroupVo) {

		return commCodeAdmDao.selectCommCodeGroupPageCount(commCodeGroupVo);
	}

	/**
	 * 공통코드그룹 목록 조회
	 * @return
	 */
	public List<CommCodeGroupVo> selectCommCodeGroupPageList(CommCodeGroupVo commCodeGroupVo) {

		return commCodeAdmDao.selectCommCodeGroupPageList(commCodeGroupVo);
	}

	/**
	 * 공통코드 목록 조회
	 * @return
	 */
	public List<CommCodeVo> selectCommCodeList(String codeGroupId) {

		CommCodeVo commCodeVo = new CommCodeVo();
		commCodeVo.setCodeGroupId(codeGroupId);
		return selectCommCodeList(commCodeVo);
	}

	/**
	 * 공통코드 목록 조회
	 * @return
	 */
	public List<CommCodeVo> selectCommCodeList(CommCodeVo commCodeVo) {

		return commCodeAdmDao.selectCommCodeList(commCodeVo);
	}

}
