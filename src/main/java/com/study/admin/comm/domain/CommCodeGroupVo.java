package com.study.admin.comm.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 공통코드그룹 vo
 */
@Getter
@Setter
public class CommCodeGroupVo extends CommPagingVo {

	/** 코드 그룹 ID */
	private String codeGroupId;

    private String codeGroupNm;

    private String codeGroupDc;

    private String useYn;

    private String delYn;

}
