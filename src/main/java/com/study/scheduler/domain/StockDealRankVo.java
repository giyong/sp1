package com.study.scheduler.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 주식매매순위
 *
 */
@Getter
@Setter
public class StockDealRankVo {

	/** 거래 일자 */
    private String dealDay;

    /** 순위 */
    private String rank;

    /** 종목 코드 */
    private String stocksCd;

    /** 종목 명 */
    private String stocksNm;

    /** 거래자 */
    private String traderType;

    /** 매매유형 */
    private String dealType;

    /** 거래량 */
    private String dealQty;

    /** 가격 */
    private String dealPrice;

    /** 하루거래량 */
    private String dayDealQty;

}
