package com.study.admin.comm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.admin.comm.domain.CommCodeGroupVo;
import com.study.admin.comm.domain.CommCodeVo;
import com.study.admin.comm.service.CommCodeAdmService;
import com.study.common.StringUtils;

/**
 * 공통코드
 */
@Controller
@RequestMapping("/admin")
public class CommCodeAdmController {

    @Autowired
    private CommCodeAdmService commCodeAdmService;

    /**
     * 공통 코드 그룹 목록 화면
     * @param model
     * @param commCodeVo
     * @return
     */
    @RequestMapping("/comm/getCommCodeGroupList")
    public String getCommCodeGroupList(Model model, CommCodeGroupVo commCodeGroupVo) {

    	commCodeGroupVo.setRecordCountPerPage(1);
    	commCodeGroupVo.setTotalRecordCount(commCodeAdmService.selectCommCodeGroupPageCount(commCodeGroupVo));

    	List<CommCodeGroupVo> commCodeGroupList = new ArrayList<CommCodeGroupVo>();

    	if (commCodeGroupVo.getTotalRecordCount() > 0) {

    		commCodeGroupList = commCodeAdmService.selectCommCodeGroupPageList(commCodeGroupVo);
    	}

    	model.addAttribute("commCodeGroupVo"  , commCodeGroupVo);
    	model.addAttribute("commCodeGroupList", commCodeGroupList);

    	return "admin/comm/commCodeGroupList";
    }

    @ResponseBody
    @RequestMapping("/comm/getCommCodeListAjax")
    public HashMap<String, Object> getCommCodeList(CommCodeVo commCodeVo) {

    	HashMap<String, Object> map = new HashMap<>();

    	if (StringUtils.isNotBlank(commCodeVo.getCodeGroupId())) {

    		//공통코드 목록 조회
    		map.put("commCodeList", commCodeAdmService.selectCommCodeList(commCodeVo));
    	}

        return map;
    }

}
