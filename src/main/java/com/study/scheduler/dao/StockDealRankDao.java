package com.study.scheduler.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.scheduler.domain.StockDealRankVo;

@Repository
public class StockDealRankDao {

    @Autowired
	private SqlSession sqlSession;

	/**
	 * 주식매매순위 등록
	 */
	public int insertStockDealRank(StockDealRankVo stockDealRankVo) {

		return sqlSession.insert("StockDealRank.insertStockDealRank", stockDealRankVo);
	}

	/**
	 * 주식매매순위 등록
	 */
	public int insertStockDealRankList(List<StockDealRankVo> stockDealRankList) {

		return sqlSession.insert("StockDealRank.insertStockDealRankList", stockDealRankList);
	}

}
