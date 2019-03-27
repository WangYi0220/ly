package com.sl.ly.controller;

import com.sl.ly.service.JudgeService;
import com.sl.ly.service.ProjectService;
import com.sl.ly.service.SponsorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Api(tags = "路演公共模块")
@RestController
@RequestMapping("/common")
public class LyCommonController {
    @Autowired
    private SponsorService sponsorService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private JudgeService judgeService;

    @ApiOperation("根据用户编号获取路演封面集合")
    @RequestMapping(value = "/list/{userUUID}", method = RequestMethod.GET)
    public List<Map<String, Object>> getLyListByUserUUID(@PathVariable("userUUID") String userUUID){
        List<Map<String, Object>> data = new ArrayList<>();
        data.addAll(sponsorService.getSponsorListByUserUUID(userUUID));
        data.addAll(projectService.getProjectListByUserUUID(userUUID));
        data.addAll(judgeService.getJudgeListByUserUUID(userUUID));
        return data;
    }
}
