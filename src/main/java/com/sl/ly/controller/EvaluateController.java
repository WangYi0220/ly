package com.sl.ly.controller;

import com.sl.ly.pojo.Evaluate;
import com.sl.ly.service.EvaluateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "打分")
@RestController
@RequestMapping("/evaluate")
public class
EvaluateController {
    @Autowired
    private EvaluateService evaluateService;

    @ApiOperation("评委评分")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean addEvaluate(@RequestBody List<Evaluate> evaluates) {
        evaluates.forEach(item -> {
            System.out.println(item);
        });
        evaluateService.addEvaluate(evaluates);
        return true;
    }

    @ApiOperation("获取项目统计评分列表")
    @RequestMapping(value = "/list/{sponsorUUID}", method = RequestMethod.GET)
    public List<Map<String, Object>> getProjectEvaluateListBySponsorUUID(@PathVariable("sponsorUUID") String sponsorUUID){
        return evaluateService.getProjectEvaluateListBySponsorUUID(sponsorUUID);
    }

    @ApiOperation("根据主办方编号获取该路演下，所有项目的汇总情况")
    @RequestMapping(value = "/list/collect/{sponsorUUID}", method = RequestMethod.GET)
    public List<Map<String, Object>> getCollectList(String sponsorUUID) {
        return evaluateService.getCollectList(sponsorUUID);
    }
}
