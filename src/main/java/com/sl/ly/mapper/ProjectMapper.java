package com.sl.ly.mapper;

import com.sl.ly.pojo.Project;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProjectMapper {
   void addProject(Project project);

   List<Map<String, Object>> getProjectListByUserUUID(@Param("userUUID") String userUUID);

   List<Map<String, Object>> getProjectListBySponsorUUID(@Param("sponsorUUID") String sponsorUUID);

   void updateProjectByPhone(@Param("userUUID") String userUUID, @Param("phone") String phone);
}
