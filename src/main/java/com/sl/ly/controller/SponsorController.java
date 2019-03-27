package com.sl.ly.controller;

import com.sl.ly.pojo.Sponsor;
import com.sl.ly.service.SponsorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

@Api(tags = "路演-主办方")
@RestController
@RequestMapping("/sponsor")
public class SponsorController {
    @Autowired
    private SponsorService sponsorService;

    @ApiOperation("创建路演")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "用户编号", name = "userUUID", paramType = "query"),
            @ApiImplicitParam(value = "路演名称", name = "sponsorName", paramType = "query"),
            @ApiImplicitParam(value = "路演单位", name = "sponsorOrg", paramType = "query"),
            @ApiImplicitParam(value = "路演地点", name = "sponsorAdd", paramType = "query"),
            @ApiImplicitParam(value = "开始时间", name = "beginTime", paramType = "query"),
            @ApiImplicitParam(value = "结束时间", name = "endTime", paramType = "query"),
            @ApiImplicitParam(value = "补充说明", name = "remark", paramType = "query"),
            @ApiImplicitParam(value = "路演海报", name = "poster", paramType = "query"),
            @ApiImplicitParam(value = "项目邀请码", name = "projectCode", paramType = "query"),
            @ApiImplicitParam(value = "评委邀请码", name = "judgeCode", paramType = "query"),
            @ApiImplicitParam(value = "0未开始 1进行中 2已结束 请前端根据时间判断后传参", name = "status", paramType = "query"),
    })
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createSponsor(@ApiIgnore Sponsor sponsor) {
        return sponsorService.createSponsor(sponsor);
    }

    //@PassToken
    @ApiOperation("根据路演编号查询路演详情(主办方)")
    @RequestMapping(value = "/get/{sponsorUUID}", method = RequestMethod.GET)
    public Sponsor getSponsorBySponsorUUID(@PathVariable("sponsorUUID") String sponsorUUID) {
        return sponsorService.getSponsorBySponsorUUID(sponsorUUID);
    }

    @ApiOperation("更新路演(主办方)")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "路演编号", name = "sponsorUUID", paramType = "query"),
            @ApiImplicitParam(value = "路演名称", name = "sponsorName", paramType = "query"),
            @ApiImplicitParam(value = "路演单位", name = "sponsorOrg", paramType = "query"),
            @ApiImplicitParam(value = "路演地点", name = "sponsorAdd", paramType = "query"),
            @ApiImplicitParam(value = "开始时间", name = "beginTime", paramType = "query"),
            @ApiImplicitParam(value = "结束时间", name = "endTime", paramType = "query"),
            @ApiImplicitParam(value = "补充说明", name = "remark", paramType = "query"),
            @ApiImplicitParam(value = "路演海报", name = "poster", paramType = "query"),
    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public boolean updateSponsor(@ApiIgnore Sponsor sponsor) {
        sponsorService.updateSponsor(sponsor);
        return true;
    }

    @ApiOperation("获取项目邀请码")
    @RequestMapping(value = "/getProjectCode/{sponsorUUID}", method = RequestMethod.GET)
    public Map<String, String> getProjectCode(@PathVariable String sponsorUUID) {
        return sponsorService.getProjectCode(sponsorUUID);
    }

    @ApiOperation("获取评委邀请码")
    @RequestMapping(value = "/getJudgeCode/{sponsorUUID}", method = RequestMethod.GET)
    public Map<String, String> getJudgeCode(@PathVariable String sponsorUUID) {
        return sponsorService.getJudgeCode(sponsorUUID);
    }
}
