package com.study.admin.news.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.admin.comm.service.CommCodeAdmService;
import com.study.admin.news.domain.NewsRssUrlVo;
import com.study.admin.news.service.NewsRssUrlAdmService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class TestController {

	@Autowired
    private CommCodeAdmService commCodeAdmService;

    @Autowired
    private NewsRssUrlAdmService newsRssService;

    @ResponseBody
    @RequestMapping("/test/news/main")
    public ResponseEntity<Object> main(Model model, @Valid NewsRssUrlVo newsRssVo) {

    	Map map = new HashMap<String, Object>();
    	
    	//공통코드 목록 조회 - G1:뉴스 언론사
    	map.put("newsCompCdList", commCodeAdmService.selectCommCodeList("G1"));

    	//공통코드 목록 조회 - G2:뉴스 분야
    	map.put("newsClCdList", commCodeAdmService.selectCommCodeList("G2"));

		map.put("newsRssVo"  , newsRssVo);
		
//		String str = null;
//		
//		if (str.equals(null)) {
//			
//		}
		
		log.debug("debugdebugdebugdebugdebugdebugdebugdebugdebugdebug");
		log.info("infoinfoinfoinfoinfoinfoinfoinfoinfoinfoinfoinfoinfo");
		
		
		
        return ResponseEntity.ok(map);
		
        
        
//		if (true) {
//			
//			throw new NullPointerException("TEST");
//		}
//		
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
    }

//    @ResponseBody
//    @PostMapping("/admin/news/main/save")
//    public HashMap<String, Object> save(NewsRssUrlVo newsRssVo) {
//
//    	//뉴스 RSS 등록
//    	newsRssService.insertNewsRss(newsRssVo);
//
//        HashMap<String, Object> map = new HashMap<>();
//
//        return map;
//    }

}
