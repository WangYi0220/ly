package com.sl.ly.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Sponsor implements Serializable {
    private String sponsorUUID;//主办方编号
    private String userUUID;//用户编号
    private String sponsorName;//路演名称
    private String sponsorOrg;//路演单位
    private String sponsorAdd;//路演地点
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginTime;//开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;//结束时间
    private String remark;//补充说明
    private String poster;//路演海报
    private String projectCode;//项目邀请码
    private String judgeCode;//评委邀请码
    private int flag;//0主办方 1评委方 2项目方
    private int status;//0未开始 1进行中 2已结束
}
