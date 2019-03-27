package com.sl.ly.controller;

import com.sl.ly.pojo.Grade;
import com.sl.ly.service.GradeService;
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

@Api(tags = "评分项")
@RestController
@RequestMapping("/grade")
public class GradeController {
    @Autowired
    private GradeService gradeService;

    @ApiOperation("添加评分项")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addGrade(Grade grade) {
        return gradeService.addGrade(grade);
    }

    @ApiOperation("删除评分项")
    @RequestMapping(value = "/del/{gradeUUID}", method = RequestMethod.GET)
    public boolean delGrade(@PathVariable("gradeUUID") String gradeUUID) {
        gradeService.delGrade(gradeUUID);
        return true;
    }

    @ApiOperation("更新评分项")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "评分项编号", name = "gradeUUID", paramType = "query"),
            @ApiImplicitParam(value = "评分项名称", name = "gradeName", paramType = "query"),
            @ApiImplicitParam(value = "分值", name = "grade", paramType = "query"),
    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public boolean updateGrade(@ApiIgnore Grade grade) {
        gradeService.updateGrade(grade);
        return true;
    }


    @ApiOperation("根据路演编号查询所有评分项")
    @RequestMapping(value = "/list/{sponsorUUID}", method = RequestMethod.GET)
    public List<Grade> getGradeListBySponsorUUID(@PathVariable("sponsorUUID") String sponsorUUID) {
        return gradeService.getGradeListBySponsorUUID(sponsorUUID);
    }
}
