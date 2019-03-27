package com.sl.ly.service;

import com.sl.ly.mapper.ProjectMapper;
import com.sl.ly.pojo.Project;
import com.sl.ly.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectMapper projectMapper;

    /**
     * 邀请项目方
     * @param project
     */
    @Override
    public String addProject(Project project) {
        String uuid = UUIDUtils.getUUID();
        project.setProjectUUID(uuid);
        projectMapper.addProject(project);
        return uuid;
    }

    /**
     * 根据用户编号获取项目方封面列表
     * @param userUUID
     * @return
     */
    @Override
    public List<Map<String, Object>> getProjectListByUserUUID(String userUUID) {
        return projectMapper.getProjectListByUserUUID(userUUID);
    }

    /**
     * 根据主办方编号获取获取项目方列表
     * @param sponsorUUID
     * @return
     */
    @Override
    public List<Map<String, Object>> getProjectListBySponsorUUID(String sponsorUUID) {
        return projectMapper.getProjectListBySponsorUUID(sponsorUUID);
    }

    /**
     * 根据手机号更新项目的用户编号(userUUID)
     * 用于用户绑定时自动设置被主办方邀请的项目的userUUID字段
     * @param userUUID
     * @param phone
     */
    @Override
    public void updateProjectByPhone(String userUUID, String phone) {
        projectMapper.updateProjectByPhone(userUUID, phone);
    }
}
