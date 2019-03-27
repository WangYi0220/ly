package com.sl.ly.controller;

import com.sl.ly.pojo.Project;
import com.sl.ly.service.ProjectService;
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

@Api(tags = "路演-项目方")
@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @ApiOperation("项目方加入路演")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sponsorUUID", value = "主办方编号", paramType = "query"),
            @ApiImplicitParam(name = "userUUID", value = "用户编号(如果无法获得userUUID请插入0)", paramType = "query"),
            @ApiImplicitParam(name = "linkMan", value = "联系人", paramType = "query"),
            @ApiImplicitParam(name = "phone", value = "电话", paramType = "query"),
            @ApiImplicitParam(name = "projectName", value = "项目名称", paramType = "query"),
    })
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProject(@ApiIgnore Project project) {
        return projectService.addProject(project);
    }

    @ApiOperation("根据主办方编号获取获取项目方列表")
    @RequestMapping(value = "/list/{sponsorUUID}", method = RequestMethod.GET)
    public List<Map<String, Object>> getProjectListBySponsorUUID(@PathVariable("sponsorUUID") String sponsorUUID) {
        return projectService.getProjectListBySponsorUUID(sponsorUUID);
    }
}
