package com.sl.ly.service;

import com.sl.ly.pojo.Project;

import java.util.List;
import java.util.Map;

public interface ProjectService {
    String addProject(Project project);

    List<Map<String, Object>> getProjectListByUserUUID(String userUUID);

    List<Map<String, Object>> getProjectListBySponsorUUID(String sponsorUUID);

    void updateProjectByPhone(String userUUID, String phone);
}
