package com.study.admin.scheduler;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.study.admin.news.domain.NewsRssUrlVo;
import com.study.admin.news.domain.NewsVo;
import com.study.admin.news.service.NewsRssUrlAdmService;
import com.study.admin.news.service.NewsAdmService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class StockDealRankScheduler {

    /**
     * 스케줄러 동작 여부 - true:동작, false:동작안함
     */
    @Value("${scheduler.stockDealRank.isRunning}")
    private Boolean isRunning;

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

        if(!isRunning) {
            return;
        }

    }

}
