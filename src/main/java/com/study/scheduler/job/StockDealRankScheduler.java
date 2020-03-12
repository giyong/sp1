package com.study.scheduler.job;

import javax.annotation.PostConstruct;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.study.scheduler.service.StockDealRankService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class StockDealRankScheduler {

    /**
     * 스케줄러 동작 여부 - true:동작, false:동작안함
     */
    @Value("${scheduler.stockDealRank.isRunning}")
    private Boolean isRunning;

    @Autowired
    private StockDealRankService stockDealRankDaoService;

    @PostConstruct
    public void init() {
        //시작 로그 출력
        log.info("Start StockDealRankScheduler");
    }

    /**
     * 10초에 한번씩 수행
     * @throws InterruptedException
     */
    @Scheduled(fixedDelayString = "10000")  //스케줄러 동작 완료 후 설정된 시간뒤에 재실행
    public void job() throws InterruptedException {

    	// TODO 실행여부를 init에서 처리할수 없을까?
    	// TODO 실행여부를 DB에서 가져오도록 변경하자
        if(!isRunning) {
            return;
        }

        // 셀렉터 가이드 : https://jsoup.org/cookbook/extracting-data/selector-syntax

        // TODO doc 전체를 DB에 저장하여 일정기간 동안 보관 후 삭제
        try {

        	String url      = "https://finance.naver.com/sise/sise_deal_rank_iframe.nhn?sosok=01&investor_gubun=9000&type=buy";  // 외국인순매수 (단위:천주, 백만원)
        	String selector = "div.box_type_m_1_top div.box_type_ms";
        	Document doc = Jsoup.connect(url).get();

        	String day = "20" + doc.select(selector).eq(1).select("div.sise_guide_date").text().replaceAll(".", "");

        	log.info("day : " + day);

            Elements el = doc.select(selector).eq(1).select("tbody tr:gt(1)");  // 첫번째 tr은 해더라서 제외

            log.info("el size : " + el.size());

            for (Element tr: el) {

            	int size = tr.select("td[colspan=4]").size();  // 가로선 tr 제외

            	if (size > 0) {
            		continue;
            	}

            	/* <tr>
                 *  <td><p class="tit"><a href="/item/main.nhn?code=005490" class="tltle" target="_top" title="POSCO">POSCO</a></p></td>
                 *  <td class="number">70</td>
                 *  <td class="number">12,180</td>
                 *  <td class="number"></td>
                 * </tr>
            	 */

            	Elements tds = tr.select("td");
            	Element td   = tds.eq(0).get(0);

            	// 종목명
            	String cd = td.select("a").attr("href").replaceAll("/item/main.nhn\\?code=", "");  // 종목코드
            	String nm = td.select("a").text();      // 종목명
            	String qty =tds.eq(1).get(0).text();    // 수량
            	String price =tds.eq(2).get(0).text();  // 금액

            	log.info("종목코드 : {}", cd);
            	log.info("종목명 : {}", nm);
            	log.info("수량 : {}", qty);
            	log.info("금액 : {}", price);

            	log.info(tr.toString());
            }

        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

}