package com.study.admin.comm.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.admin.comm.domain.CommCodeGroupVo;
import com.study.admin.comm.domain.CommCodeVo;

@Repository
public class CommCodeAdmDao {

    @Autowired
	private SqlSession sqlSession;

    /**
     * 공통코드그룹 건수 조회
     * @return
     */
    public int selectCommCodeGroupPageCount(CommCodeGroupVo commCodeGroupVo) {

    	return this.sqlSession.selectOne("CommCodeAdm.selectCommCodeGroupPageCount", commCodeGroupVo);
    }

    /**
     * 공통코드그룹 목록 조회
     * @return
     */
    public List<CommCodeGroupVo> selectCommCodeGroupPageList(CommCodeGroupVo commCodeGroupVo) {

    	return this.sqlSession.selectList("CommCodeAdm.selectCommCodeGroupPageList", commCodeGroupVo);
    }

    /**
	 * 공통코드 목록 조회
	 * @return
	 */
	public List<CommCodeVo> selectCommCodeList(CommCodeVo commCodeVo) {

		return this.sqlSession.selectList("CommCodeAdm.selectCommCodeList", commCodeVo);
	}

}
