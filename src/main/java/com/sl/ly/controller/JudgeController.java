package com.sl.ly.controller;

import com.sl.ly.pojo.Judge;
import com.sl.ly.service.JudgeService;
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

import java.util.List;
import java.util.Map;

@Api(tags = "路演-评委")
@RestController
@RequestMapping("/judge")
public class JudgeController {
    @Autowired
    private JudgeService judgeService;

    @ApiOperation("添加评委")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sponsorUUID", value = "主办方编号", paramType = "query"),
            @ApiImplicitParam(name = "userUUID", value = "用户编号(如果无法获得userUUID请插入0)", paramType = "query"),
            @ApiImplicitParam(name = "judgeName", value = "评委姓名", paramType = "query"),
            @ApiImplicitParam(name = "phone", value = "手机", paramType = "query"),
            @ApiImplicitParam(name = "organ", value = "机构", paramType = "query"),
    })

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addJudge(@ApiIgnore Judge judge) {
       return judgeService.addJudge(judge);
    }

    @ApiOperation("根据项目编号获取评委列表")
    @RequestMapping(value = "/list/{sponsorUUID}", method = RequestMethod.GET)
    public List<Map<String, Object>> getJudgeListBySponsorUUID(@PathVariable("sponsorUUID") String sponsorUUID){
        return judgeService.getJudgeListBySponsorUUID(sponsorUUID);
    }

    @ApiOperation("更新评委")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "judgeUUID", value = "评委编号", paramType = "query"),
            @ApiImplicitParam(name = "judgeName", value = "评委姓名", paramType = "query"),
            @ApiImplicitParam(name = "phone", value = "手机", paramType = "query"),
            @ApiImplicitParam(name = "organ", value = "机构", paramType = "query"),
    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public boolean updateJudgeByJudgeUUID(@ApiIgnore Judge judge){
        judgeService.updateJudgeByJudgeUUID(judge);
        return true;
    }

    @ApiOperation("删除评委(尚未开发)")
    @RequestMapping(value = "/del/{judgeUUID}", method = RequestMethod.GET)
    public boolean delJudgeByJudgeUUID(@PathVariable("judgeUUID") String judgeUUID){
        judgeService.delJudgeByJudgeUUID(judgeUUID);
        return true;
    }
}
