package com.study.admin.comm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.admin.comm.domain.CommCodeGroupVo;
import com.study.admin.comm.domain.CommCodeVo;
import com.study.admin.comm.service.CommCodeAdmService;
import com.study.common.StringSp1Utils;

/**
 * 공통코드
 */
@Controller
@RequestMapping("/admin")
public class CommCodeAdmController {

    @Autowired
    private CommCodeAdmService commCodeAdmService;

    /**
     * 공통 코드 그룹 등록
     * @param commCodeGroupVo
     * @return
     */
    @ResponseBody
    @RequestMapping("/comm/insertCommCodeGroupAjax")
    public HashMap<String, Object> insertCommCodeGroupAjax(CommCodeGroupVo commCodeGroupVo) {

    	HashMap<String, Object> map = new HashMap<>();

    	if (StringSp1Utils.isBlank(commCodeGroupVo.getCodeGroupId())) {
    		map.put("RESULT_CD" , "9999");
    		map.put("RESULT_MSG", "그룹ID가 없습니다.");
    		return map;
    	}

    	if (StringSp1Utils.isBlank(commCodeGroupVo.getCodeGroupNm())) {
    		map.put("RESULT_CD" , "9999");
    		map.put("RESULT_MSG", "그룹명이 없습니다.");
    		return map;
    	}

    	commCodeGroupVo.setUseYn("Y");
    	commCodeGroupVo.setDelYn("N");
    	commCodeAdmService.insertCommCodeGroup(commCodeGroupVo);

    	return map;
    }

    /**
     * 공통 코드 그룹 수정
     * @param commCodeGroupVo
     * @return
     */
    @ResponseBody
    @RequestMapping("/comm/updateCommCodeGroupAjax")
    public HashMap<String, Object> updateCommCodeGroupAjax(CommCodeGroupVo commCodeGroupVo) {

    	// TODO 유효성 검사

    	commCodeAdmService.updateCommCodeGroup(commCodeGroupVo);

    	HashMap<String, Object> map = new HashMap<>();
    	return map;
    }

    /**
     * 공통 코드 그룹 목록 화면
     * @param model
     * @param commCodeVo
     * @return
     */
    @RequestMapping("/comm/getCommCodeGroupList")
    public String getCommCodeGroupList(Model model, CommCodeGroupVo commCodeGroupVo) {

    	commCodeGroupVo.setTotalRecordCount(commCodeAdmService.selectCommCodeGroupPageCount(commCodeGroupVo));

    	List<CommCodeGroupVo> commCodeGroupList = new ArrayList<CommCodeGroupVo>();

    	if (commCodeGroupVo.getTotalRecordCount() > 0) {

    		commCodeGroupList = commCodeAdmService.selectCommCodeGroupPageList(commCodeGroupVo);
    	}

    	model.addAttribute("commCodeGroupVo"  , commCodeGroupVo);
    	model.addAttribute("commCodeGroupList", commCodeGroupList);

    	return "admin/comm/commCodeGroupList";
    }

    /**
     * 공통 코드 그룹 목록 Ajax
     * @param model
     * @param commCodeVo
     * @return
     */
    @RequestMapping(value = "/comm/getCommCodeGroupListAjaxLoad", method = {RequestMethod.GET, RequestMethod.POST})
    public String getCommCodeGroupListAjaxLoad(Model model, CommCodeGroupVo commCodeGroupVo) {

    	commCodeGroupVo.setTotalRecordCount(commCodeAdmService.selectCommCodeGroupPageCount(commCodeGroupVo));

    	List<CommCodeGroupVo> commCodeGroupList = new ArrayList<CommCodeGroupVo>();

    	if (commCodeGroupVo.getTotalRecordCount() > 0) {

    		commCodeGroupList = commCodeAdmService.selectCommCodeGroupPageList(commCodeGroupVo);
    	}

    	model.addAttribute("commCodeGroupVo"  , commCodeGroupVo);
    	model.addAttribute("commCodeGroupList", commCodeGroupList);

    	return "admin/comm/innerCommCodeGroupList";
    }

    /**
     * 공통 코드 목록 조회 Ajax
     * @param commCodeVo
     * @return
     */
    @ResponseBody
    @RequestMapping("/comm/getCommCodeListAjax")
    public HashMap<String, Object> getCommCodeList(CommCodeVo commCodeVo) {

    	HashMap<String, Object> map = new HashMap<>();

    	if (StringSp1Utils.isNotBlank(commCodeVo.getCodeGroupId())) {

    		//공통코드 목록 조회
    		map.put("commCodeList", commCodeAdmService.selectCommCodeList(commCodeVo));
    	}

        return map;
    }

}
