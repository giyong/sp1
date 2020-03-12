package com.study.scheduler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.scheduler.dao.StockDealRankDao;
import com.study.scheduler.domain.StockDealRankVo;

/**
 * 주식매매순위 서비스
 */
@Service
public class StockDealRankService {

	@Autowired
	private StockDealRankDao stockDealRankDao;

	/**
	 * 주식매매순위 등록
	 */
	public int insertStockDealRank(StockDealRankVo stockDealRankVo) {

		return stockDealRankDao.insertStockDealRank(stockDealRankVo);
	}

	/**
	 * 주식매매순위 등록
	 */
	public int insertStockDealRankList(List<StockDealRankVo> stockDealRankList) {

		return stockDealRankDao.insertStockDealRankList(stockDealRankList);
	}

}
