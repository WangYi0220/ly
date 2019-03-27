package com.sl.ly.mapper;

import com.sl.ly.pojo.Grade;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GradeMapper {
    void addGrade(Grade grade);

    void delGrade(@Param("gradeUUID") String gradeUUID);

    void updateGrade(Grade grade);

    List<Grade> getGradeListBySponsorUUID(@Param("sponsorUUID") String sponsorUUID);
}
